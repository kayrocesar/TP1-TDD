package test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import app.SistemaEstoque;
import enums.Categoria;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroProdutoTest {

    private SistemaEstoque sistemaEstoque;
    private Produto produtoNomeEmBranco,produtoEmBranco,produtoNormal,produtoNormal2,produtoNormal3;
    @BeforeEach
    public void setup() {
        sistemaEstoque = new SistemaEstoque();
        produtoNomeEmBranco = new Produto("",
                "Brigadeiro gourmet com chocolate 60% cacau",
                "123456100",
                3.0,
                10.0,
                200,
                50,
                LocalDate.of(2024, 1, 5),
                1,
                Categoria.DOCE,
                new Fornecedor("Doces do seu João INC", "41.100.040/0001-61"));
        produtoEmBranco = new Produto("",
                "",
                "",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        produtoNormal = new Produto("Brigadeiro",
                "Brigadeiro gourmet com chocolate 60% cacau",
                "123456100",
                3.0,
                10.0,
                200,
                50,
                LocalDate.of(2024, 1, 5),
                1,
                Categoria.DOCE,
                new Fornecedor("Doces do seu João INC", "41.100.040/0001-61"));
        produtoNormal2 = new Produto("Sanduíche",
                "Misto quente completo",
                "123456400",
                2.0,
                4.0,
                50,
                20,
                LocalDate.of(2025, 1, 5),
                1,
                Categoria.SANDUICHE,
                new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61"));
        produtoNormal3 = new Produto("Coca Cola  2L",
                "Coca Cola 2L Zero Açúcar",
                "123451000",
                3.0,
                7.0,
                200,
                100,
                LocalDate.of(2030, 10, 20),
                1,
                Categoria.REFRIGERANTE,
                new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51"));
    }
    @Test
    public void cadastrarProdutoTest() throws DescricaoEmBrancoException, ValorInvalidoException {
        sistemaEstoque.cadastrarProduto(produtoNormal);
        assertEquals(1, sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarDoisProdutosTest() throws DescricaoEmBrancoException, ValorInvalidoException {
        sistemaEstoque.cadastrarProduto(produtoNormal);
        sistemaEstoque.cadastrarProduto(produtoNormal);
        assertEquals(2, sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarTresProdutosTest() throws DescricaoEmBrancoException, ValorInvalidoException {
        sistemaEstoque.cadastrarProduto(produtoNormal);
        sistemaEstoque.cadastrarProduto(produtoNormal);
        sistemaEstoque.cadastrarProduto(produtoNormal);
        assertEquals(3, sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarProdutoComCampoEmBrancoTest() {
        assertThrows(DescricaoEmBrancoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNomeEmBranco));
    }
    @Test
    public void cadastrarDoisProdutoComCampoEmBrancoTest() {
        assertThrows(DescricaoEmBrancoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNomeEmBranco));
        assertThrows(DescricaoEmBrancoException.class, () -> sistemaEstoque.cadastrarProduto(produtoEmBranco));
    }
    @Test
    public void cadastrarTresProdutoComCampoEmBrancoTest() {
        assertThrows(DescricaoEmBrancoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNomeEmBranco));
        assertThrows(DescricaoEmBrancoException.class, () -> sistemaEstoque.cadastrarProduto(produtoEmBranco));
        assertDoesNotThrow(() -> sistemaEstoque.cadastrarProduto(produtoNormal));
    }


    @Test
    public void cadastrarProdutoComValoresInvalidos() {
        produtoNormal.setCusto(0.0);
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal));

    }
    @Test
    public void cadastrarDoisProdutosComValoresInvalidos() {
        produtoNormal.setCusto(0.0);
        produtoNormal2.setPrecoVenda(-1.0);
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal));
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal2));

    }
    @Test
    public void cadastrarTresProdutosComValoresInvalidos() {
        produtoNormal.setCusto(-10.0);
        produtoNormal2.setQtd(-1);
        produtoNormal3.setQtdMinima(-7);
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal));
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal2));
        assertThrows(ValorInvalidoException.class, () -> sistemaEstoque.cadastrarProduto(produtoNormal3));
    }




}
