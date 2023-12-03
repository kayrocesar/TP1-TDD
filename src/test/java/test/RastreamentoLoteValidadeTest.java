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
import java.util.ArrayList;

public class RastreamentoLoteValidadeTest {


    private RastreamentoLoteValidade rastreamentoLoteValidade;
    private Produto produto, produto2, produto3;

    @BeforeEach
    public void setup() {
        rastreamentoLoteValidade = new RastreamentoLoteValidade();
        produto = new Produto("Brigadeiro",
                "Lata de Brigadeiro 500g pronta para uso",
                "123456100",
                2.0,
                10.0,
                200,
                50,
                LocalDate.parse("2023-12-13"),
                1, Categoria.DOCE,
                new Fornecedor("Doces da Mamãe SA", "41.100.040/0001-61"));
        produto2 = new Produto("Sanduíche Frio",
                "Sanduíche de frango desfiado com alface e tomate pronto para consumo",
                "123451222",
                2.0,
                5.0,
                50,
                20,
                LocalDate.parse("2023-12-13"),
                1,
                Categoria.SANDUICHE,
                new Fornecedor("Sanduíches do Seu Carlos", "60.100.040/0001-61"));
        produto3 = new Produto("Coca Cola 2L",
                "Refrigerante Coca Cola 2L Zero Açúcar com embalagem retornavél",
                "123451000",
                3.0,
                7.0,
                80,
                100,
                LocalDate.parse("2030-10-20"),
                2,
                Categoria.REFRIGERANTE,
                new Fornecedor("Coca Cola Brasil", "50.100.040/0001-51"));
    }

    @Test
    public void quantidadeTotalProdutoTest() {
        assertEquals(200, rastreamentoLoteValidade.quantidadeTotalProduto(produto));
    }

    @Test
    public void quantidadeTotalProdutoTest2() {
        assertEquals(200, rastreamentoLoteValidade.quantidadeTotalProduto(produto));
        assertEquals(50, rastreamentoLoteValidade.quantidadeTotalProduto(produto2));
    }

    @Test
    public void quantidadeTotalProdutoTest3() {
        assertEquals(200, rastreamentoLoteValidade.quantidadeTotalProduto(produto));
        assertEquals(50, rastreamentoLoteValidade.quantidadeTotalProduto(produto2));
        assertEquals(80, rastreamentoLoteValidade.quantidadeTotalProduto(produto3));
    }
    @Test
    public void quantidadeTotalProdutoLoteTest(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        assertEquals(200, rastreamentoLoteValidade.quantidadeTotalProdutoLote(produtos, 1));
    }
    @Test
    public void quantidadeTotalProdutoLoteTest2(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        assertEquals(250, rastreamentoLoteValidade.quantidadeTotalProdutoLote(produtos, 1));
    }
    @Test
    public void quantidadeTotalProdutoLoteTest3(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        produtos.add(produto3);
        assertEquals(250, rastreamentoLoteValidade.quantidadeTotalProdutoLote(produtos, 1));
    }

    @Test
    public void emiteAlertLoteVencimentoTest(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        assertEquals(true, rastreamentoLoteValidade.emiteAlertLoteVencimento(produtos, 1));
    }
    @Test
    public void emiteAlertLoteVencimentoTest2(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        assertEquals(true, rastreamentoLoteValidade.emiteAlertLoteVencimento(produtos, 1));
    }
    @Test
    public void emiteAlertLoteVencimentoTest3(){
        ArrayList<Produto> produtos= new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        produtos.add(produto3);
        assertEquals(true, rastreamentoLoteValidade.emiteAlertLoteVencimento(produtos, 2));
    }





}
