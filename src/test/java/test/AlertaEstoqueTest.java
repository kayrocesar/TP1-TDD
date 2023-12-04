package test;

import Exceptions.EstoqueNegativoException;
import enums.Categoria;
import model.Alerta;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


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

    @DisplayName("Deve emitir um alerta ao atingir a quantidade mínimo ou menor que a quantidade mínima no estoque")
    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "5, 10",
            "0, 5",
    })
    void emitirAlertaDeEstoqueBaixoTest(int quantidade, int quantidadeMin) throws EstoqueNegativoException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Dado que o estoque tem a quantidade de produtos igual a quantidade mínima
        produtoMocked.setQtd(quantidade);
        produtoMocked.setQtdMinima(quantidadeMin);

        // Quando a função de validarQuantidadeEstoqueProduto for chamada
        alertaTester.emitirAlerta(produtoMocked);

        System.setOut(System.out);

        String textoDaStdOut = outputStream.toString().trim();

        // Deve avisar que tem quantidade mínima
        assertEquals("Produto Bolo de chocolate atingiu " + quantidade + " no estoque.\n A quantidade mínima é "+quantidadeMin + "\nFornecedor : Bolos da dona maria LTDA", textoDaStdOut);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "-2",
            "-3",
    })
    @DisplayName("Deve emitir uma exceção quando a quantidade no estoque ficar negativa")
    void emitirExcecaoEstoqueNegativoTest(int quantidade) throws EstoqueNegativoException{
        // Dado que o estoque tem a quantidade de produtos igual a quantidade mínima
        produtoMocked.setQtd(quantidade);

        assertThrows(EstoqueNegativoException.class, () -> alertaTester.validarQuantidadeEstoqueProduto(produtoMocked));
    }

    @Test
    @DisplayName("Não deve emitir uma exceção quando a quantidade é zero")
    void emitirExcecaoEstoqueNegativoComValorZeroTest() throws EstoqueNegativoException{
        // Dado que o estoque tem a quantidade de produtos igual a quantidade mínima
        produtoMocked.setQtd(0);

        assertDoesNotThrow(() -> alertaTester.validarQuantidadeEstoqueProduto(produtoMocked));
    }
}
