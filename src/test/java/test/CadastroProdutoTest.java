package test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import app.CadastroProduto;
import enums.Categoria;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroProdutoTest {

    private CadastroProduto cadastroProduto;
    @BeforeEach
    public void setup() {
        cadastroProduto = new CadastroProduto();
    }

    static Stream<Arguments> produtosNormais() {
        return Stream.of(
                Arguments.of(new Produto("Brigadeiro",
                        "Lata de Brigadeiro 500g pronta para uso ",
                        "123456100",
                        3.0,
                        10.0,
                        200,
                        50,
                        LocalDate.parse("2024-01-05"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61"))),
                Arguments.of(new Produto("Coca Cola 2L",
                        "Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                        "123451000",
                        3.0,
                        7.0,
                        200,
                        100,
                        LocalDate.parse("2030-10-20"),
                        1,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51"))),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "123451222",
                        2.0,
                        5.0,
                        50,
                        20,
                        LocalDate.parse("2023-12-25"),
                        1,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")))
        );
    }
    @ParameterizedTest
    @MethodSource("produtosNormais")
    public void cadastrarProdutoNormalTest(Produto produto) throws DescricaoEmBrancoException, ValorInvalidoException {
        cadastroProduto.cadastrarProduto(produto);
        assertTrue(cadastroProduto.getProdutos().contains(produto));
    }

    static Stream<Arguments> produtosComCampoVazio() {
        return Stream.of(
                Arguments.of(new Produto(" ",
                        " Lata de Brigadeiro 500g pronta para uso",
                        "123456100",
                        3.0,
                        10.0,
                        200,
                        50,
                        LocalDate.parse("2024-01-05"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61"))),
                Arguments.of(new Produto("Coca Cola 2L",
                        "  ",
                        "123451000",
                        3.0,
                        7.0,
                        200,
                        100,
                        LocalDate.parse("2030-10-20"),
                        1,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51"))),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "  ",
                        2.0,
                        5.0,
                        50,
                        20,
                        LocalDate.parse("2023-12-25"),
                        1,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")))
        );
    }
    @ParameterizedTest
    @MethodSource("produtosComCampoVazio")
    public void cadastrarProdutoDescricaoEmBrancoTest(Produto produto) {
        assertThrows(DescricaoEmBrancoException.class, () -> cadastroProduto.cadastrarProduto(produto));
    }

    static Stream<Arguments> produtosComValorInvalido() {
        return Stream.of(
                Arguments.of(new Produto("Brigadeiro",
                        "Lata de Brigadeiro 500g pronta para uso",
                        "123456100",
                        0.0,
                        10.0,
                        200,
                        50,
                         LocalDate.parse("2024-01-05"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61"))),
                Arguments.of(new Produto("Coca Cola 2L",
                        " Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                        "123451000",
                        3.0,
                        -1.0,
                        200,
                        100,
                        LocalDate.parse("2030-10-20"),
                        1,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51"))),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "123451222 ",
                        2.0,
                        5.0,
                        -7,
                        20,
                        LocalDate.parse("2023-12-25"),
                        1,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")))
        );
    }
    @ParameterizedTest
    @MethodSource("produtosComValorInvalido")
    public void cadastrarProdutoValorInvalidoTest(Produto produto) {
        assertThrows(ValorInvalidoException.class, () -> cadastroProduto.cadastrarProduto(produto));
    }



}