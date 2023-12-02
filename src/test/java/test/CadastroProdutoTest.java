package test;

import app.SistemaEstoque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroProdutoTest {

    private SistemaEstoque sistemaEstoque;

    @BeforeEach
    public void setup() {
        sistemaEstoque = new SistemaEstoque();
    }

    @Test
    public void cadastrarProduto()  {

        assertEquals(3, sistemaEstoque.getTotalProdutos());



    }

}
