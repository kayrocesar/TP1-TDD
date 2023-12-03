package test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import app.CadastroProduto;
import app.RastreamentoLoteValidade;
import enums.Categoria;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class RastreamentoLoteValidadeTest {


    private RastreamentoLoteValidade rastreamentoLoteValidade;
    private static ArrayList<Produto> produtos= new ArrayList<>();
    private static ArrayList<Produto> produtosVerificicacaoValidade= new ArrayList<>();


    @BeforeEach
    public void setup() {
        rastreamentoLoteValidade = new RastreamentoLoteValidade();
    }

    static Stream<Arguments> produtos1() {
        return Stream.of(
                Arguments.of( new Produto("Brigadeiro",
                        "Lata de Brigadeiro 500g pronta para uso",
                        "123456100",
                        2.0,
                        10.0,
                        200,
                        50,
                        LocalDate.parse("2023-12-13"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61")),200),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "123451222",
                        2.0,
                        5.0,
                        50,
                        20,
                        LocalDate.parse("2023-12-13"),
                        1,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")),50),
                Arguments.of(new Produto("Coca Cola 2L",
                        "Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                        "123451000",
                        3.0,
                        7.0,
                        80,
                        100,
                        LocalDate.parse("2030-10-20"),
                        2,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51")),80));
    }
    @ParameterizedTest
    @MethodSource("produtos1")
    public void quantidadeTotalProdutoTest(Produto produto, Integer qtdTotalEsperada) {
        assertEquals(qtdTotalEsperada, rastreamentoLoteValidade.quantidadeTotalProduto(produto));
    }



    static Stream<Arguments> produtos2() {
        return Stream.of(
                Arguments.of( new Produto("Brigadeiro",
                        "Lata de Brigadeiro 500g pronta para uso",
                        "123456100",
                        2.0,
                        10.0,
                        200,
                        50,
                        LocalDate.parse("2023-12-13"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61")),200),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "123451222",
                        2.0,
                        5.0,
                        50,
                        20,
                        LocalDate.parse("2023-12-13"),
                        1,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")),250),
                Arguments.of(new Produto("Coca Cola 2L",
                        "Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                        "123451000",
                        3.0,
                        7.0,
                        80,
                        100,
                        LocalDate.parse("2030-10-20"),
                        2,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51")),250));
    }
    @ParameterizedTest
    @MethodSource("produtos2")
    public void quantidadeTotalProdutoLoteTest(Produto produto, Integer qtdTotalEsperada)  {
        produtos.add(produto);
        assertEquals(qtdTotalEsperada, rastreamentoLoteValidade.quantidadeTotalProdutoLote(produtos, 1));
    }


    static Stream<Arguments> produtos3() {
        return Stream.of(
                Arguments.of( new Produto("Brigadeiro",
                        "Lata de Brigadeiro 500g pronta para uso",
                        "123456100",
                        2.0,
                        10.0,
                        200,
                        50,
                        LocalDate.parse("2023-12-13"),
                        1, Categoria.DOCE,
                        new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61")),true,1),
                Arguments.of(new Produto("Sanduíche Frio",
                        "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                        "123451222",
                        2.0,
                        5.0,
                        50,
                        20,
                        LocalDate.parse("2023-12-13"),
                        2,
                        Categoria.SANDUICHE,
                        new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61")),true,2),
                Arguments.of(new Produto("Coca Cola 2L",
                        "Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                        "123451000",
                        3.0,
                        7.0,
                        80,
                        100,
                        LocalDate.parse("2030-10-20"),
                        3,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51")),true,3));
    }
    @ParameterizedTest
    @MethodSource("produtos3")
    public void emiteAlertLoteVencimentoTest(Produto produto, Boolean emitiuAlerta, Integer qdtLotesDiferentes)  {
        produtosVerificicacaoValidade.add(produto);
        assertEquals(true, rastreamentoLoteValidade.emiteAlertLoteVencimento(produtosVerificicacaoValidade, qdtLotesDiferentes));
    }






}
