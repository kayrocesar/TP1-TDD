package test;

import Exceptions.DescricaoEmBrancoException;
import app.SistemaEstoque;
import enums.Categoria;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroProdutoTest {

    private SistemaEstoque sistemaEstoque;

    @BeforeEach
    public void setup() {
        sistemaEstoque = new SistemaEstoque();
    }

    @Test
    public void cadastrarProdutoTest() throws DescricaoEmBrancoException {
        Produto produto1 = new Produto("Bolo de chocolate",
                 "Bolo de chocolate (1kg) com cobertura de morango",
                "123456789",
                10.0,
                25.0,
                10,
                5,
                LocalDate.of(2024,8,5),
                1,
                Categoria.BOLO,
                new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51"));

        sistemaEstoque.cadastrarProduto(produto1);
        assertEquals(1,sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarDoisProdutosTest() throws DescricaoEmBrancoException {
        Produto produto1 = new Produto("Bolo de chocolate",
                "Bolo de chocolate (1kg) com cobertura de morango",
                "123456789",
                10.0,
                25.0,
                10,
                5,
                LocalDate.of(2024,8,5),
                1,
                Categoria.BOLO,
                new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51"));
        Produto produto2 = new Produto("Salgado ",
                "coxinha",
                "123456700",
                5.0,
                18.0,
                100,
                20,
                LocalDate.of(2024,8,5),
                1,
                Categoria.SALGADO,
                new Fornecedor("Salgados do seu Zé SA", "40.600.040/0001-51"));

        sistemaEstoque.cadastrarProduto(produto1);
        sistemaEstoque.cadastrarProduto(produto2);
        assertEquals(2,sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarTresProdutosTest() throws DescricaoEmBrancoException {
        Produto produto1 = new Produto("Bolo de chocolate",
                "Bolo de chocolate (1kg) com cobertura de morango",
                "123456789",
                10.0,
                25.0,
                10,
                5,
                LocalDate.of(2024,8,5),
                1,
                Categoria.BOLO,
                new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51"));
        Produto produto2 = new Produto("Salgado ",
                "coxinha",
                "123456700",
                5.0,
                18.0,
                100,
                20,
                LocalDate.of(2024,8,5),
                1,
                Categoria.SALGADO,
                new Fornecedor("Salgados do seu Zé SA", "40.600.040/0001-51"));
        Produto produto3 = new Produto("Brigadeiro",
                "Brigadeiro gourmet com chocolate 60% cacau",
                "123456100",
                3.0,
                10.0,
                200,
                50,
                LocalDate.of(2024,1,5),
                1,
                Categoria.DOCE,
                new Fornecedor("Doces do seu João INC", "41.100.040/0001-61"));

        sistemaEstoque.cadastrarProduto(produto1);
        sistemaEstoque.cadastrarProduto(produto2);
        sistemaEstoque.cadastrarProduto(produto3);
        assertEquals(3,sistemaEstoque.getProdutos().size());
    }


}
