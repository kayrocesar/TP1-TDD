package test;

import Exceptions.DescricaoEmBrancoException;
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
    private Produto produtoNomeEmBranco,produtoEmBranco,produtoNormal;
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

    }
    @Test
    public void cadastrarProdutoTest() throws DescricaoEmBrancoException {
        sistemaEstoque.cadastrarProduto(produtoNormal);
        assertEquals(1, sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarDoisProdutosTest() throws DescricaoEmBrancoException {
        sistemaEstoque.cadastrarProduto(produtoNormal);
        sistemaEstoque.cadastrarProduto(produtoNormal);
        assertEquals(2, sistemaEstoque.getProdutos().size());
    }
    @Test
    public void cadastrarTresProdutosTest() throws DescricaoEmBrancoException {
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

}
