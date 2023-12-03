package test;

import app.CadastroProduto;
import app.RastreamentoLoteValidade;
import enums.Categoria;
import model.Fornecedor;
import model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class RastreamentoLoteValidadeTest {


    private RastreamentoLoteValidade rastreamentoLoteValidade ;
    private Produto produto;

    @BeforeEach
    public void setup() {
        rastreamentoLoteValidade  = new RastreamentoLoteValidade();
        produto = new Produto("Brigadeiro",
                "Lata de Brigadeiro 500g pronta para uso",
                "123456100",
                2.0,
                10.0,
                200,
                50,
                LocalDate.parse("2024-01-05"),
                1, Categoria.DOCE,
                new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61"));
    }
    @Test
    public void quantidadeTotalProdutoTest(){
        assertEquals(200,rastreamentoLoteValidade.quantidadeTotalProduto(produto));
    }


}
