package test;

import Exceptions.EstoqueNegativoException;
import enums.Categoria;
import model.Alerta;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AlertaEstoqueTest {

    Alerta alertaTester;
    Produto produtoMocked;

    @BeforeEach
    public void setup(){
        alertaTester = new Alerta();

        produtoMocked = new Produto(
                "Bolo de chocolate",
                "Bolo de chocolate (1kg) com cobertura de morango",
                "123456789",
                10.0,
                25.0,
                5,
                5,
                LocalDate.of(2024,8,5),
                1,
                Categoria.BOLO,
                new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51")
        );
    }

    @Test
    @DisplayName("Deve emitir um alerta ao atingir a quantidade mínimo no estoque")
    void emitirAlertaDeEstoqueBaixoTest() throws EstoqueNegativoException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Dado que o estoque tem a quantidade de produtos igual a quantidade mínima
        produtoMocked.setQtd(5);
        produtoMocked.setQtdMinima(5);

        // Quando a função de validarQuantidadeEstoqueProduto for chamada
        alertaTester.emitirAlerta(produtoMocked);

        System.setOut(System.out);

        String textoDaStdOut = outputStream.toString().trim();

        // Deve avisar que tem quantidade mínima
        assertEquals("Produto atingiu quantidade mínima", textoDaStdOut);
    }

    @Test
    @DisplayName("Deve emitir uma exceção quando a quantidade no estoque ficar negativa")
    void emitirExcecaoEstoqueNegativoTest() throws EstoqueNegativoException{
        // Dado que o estoque tem a quantidade de produtos igual a quantidade mínima
        produtoMocked.setQtd(-1);

        assertThrows(EstoqueNegativoException.class, () -> alertaTester.validarQuantidadeEstoqueProduto(produtoMocked));
    }
}
