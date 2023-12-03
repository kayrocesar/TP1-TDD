package test;

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
    public void cadastrarProdutoTest()  {
        Produto produto1 = new Produto("Bolo de chocolate",
                 "Bolo de chocolate (1kg) com cobertura de morango",
                "123456789",
                10.0,
                25.0,
                10,
                5,
                LocalDate.of(2020,8,5),
                1,
                Categoria.BOLO,
        new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51"));

        sistemaEstoque.cadastrarProduto(produto1);
        assertEquals(produto1,sistemaEstoque.getProdutos().get(0));

    }







}
