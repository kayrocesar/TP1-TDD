package test;
import enums.Categoria;
import model.Fornecedor;
import model.ConsultaEstoque;
import java.time.LocalDate;
import model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Consultar estoque")
class ConsultaEstoqueTest {

    @ParameterizedTest
    @MethodSource("produtos")
    public void consultarEstoqueTest(Produto produto, String esperado) {
        ConsultaEstoque consultaEstoque = new ConsultaEstoque();
        String estoque = consultaEstoque.consultarEstoque(produto);

        assertEquals(esperado, estoque);
    }

    private static Stream<Arguments> produtos() {
        return Stream.of(
                Arguments.of(new Produto("Bolo de chocolate",
                        "Bolo de chocolate (1kg) com cobertura de morango",
                        "123456789",
                        10.0,
                        25.0,
                        10,
                        5,
                        LocalDate.of(2020,8,5),
                        1,
                        Categoria.BOLO,
                        new Fornecedor("Bolos da dona maria LTDA", "42.679.040/0001-51")), "Bolo de chocolate: 10"),
                Arguments.of(new Produto("Chocolate ao leite",
                        "Chocolate ao leite",
                        "987654321",
                        5.0,
                        10.0,
                        30,
                        10,
                        LocalDate.of(2023,12,3),
                        2,
                        Categoria.DOCE,
                        new Fornecedor("Cacau Show", "42.679.040/0001-51")), "Chocolate ao leite: 30"),
                Arguments.of(new Produto("Sanduiche natural",
                        "Sanduiche Natural com alface e tomate",
                        "123456789",
                        5.0,
                        10.0,
                        20,
                        10,
                        LocalDate.of(2023,12,3),
                        4,
                        Categoria.SANDUICHE,
                        new Fornecedor("McDonalds", "40.649.040/0001-51")), "Sanduiche natural: 20"),
                Arguments.of(new Produto("Fanta",
                        "Fanta laranja de 2 litros",
                        "987654321",
                        2.0,
                        8.0,
                        50,
                        10,
                        LocalDate.of(2023,12,3),
                        5,
                        Categoria.REFRIGERANTE,
                        new Fornecedor("Coca Cola", "34.600.040/0001-51")), "Fanta: 50"),
                Arguments.of(new Produto("Salgadinho",
                        "Salgadinho 250 gramas",
                        "451237895",
                        5.0,
                        15.0,
                        50,
                        10,
                        LocalDate.of(2023,12,3),
                        6,
                        Categoria.SALGADO,
                        new Fornecedor("Cacau Show", "42.679.040/0001-51")), "Salgadinho: 50")
        );
    }
}