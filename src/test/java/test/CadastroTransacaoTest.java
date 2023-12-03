package test;

import app.GestaoTransacoes;
import enums.*;
import model.Fornecedor;
import model.Produto;
import model.ProdutoQuantidade; 

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class CadastroTransacaoTest {
	
	private GestaoTransacoes gestao;
	
	@BeforeEach
	public void setup() {
		gestao = new GestaoTransacoes(); 
	}
		
	@Test
	public void testCadastroTransacao() { 
        Produto produto1 = new Produto("Coca cola",
                "Coca cola de 2 litros sem acucar",
               "271462742",
               20.0,
               10.0,
               50,
               2,
               LocalDate.of(2023,12,1),
               1,
               Categoria.REFRIGERANTE,
               new Fornecedor("Brasal Refrigerantes LTDA", "42.679.040/0001-51"));
        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto1, 2); 
        ArrayList<ProdutoQuantidade> produtos = new ArrayList<> ();  
        produtos.add(produtoQuantidade);
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produtos, TipoTransacao.VENDA); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
	}
	
	@Test
	public void testCadastroDuasTransacao() { 
        Produto produto1 = new Produto("Coca cola",
                "Coca cola de 2 litros sem acucar",
               "271462742",
               20.0,
               10.0,
               50,
               2,
               LocalDate.of(2023,12,1),
               1,
               Categoria.REFRIGERANTE,
               new Fornecedor("Brasal Refrigerantes LTDA", "42.679.040/0001-51"));
        Produto produto2 = new Produto("Iogurte Grego",
                "Iogurte Grego de Mousse de Limão",
               "241242422",
               2.50,
               4.0,
               30,
               1,
               LocalDate.of(2023,12,22),
               1,
               Categoria.IOGURTE,
               new Fornecedor("ITALAC LTDA", "42.679.040/0001-51"));
        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto1, 2); 
        ProdutoQuantidade produtoQuantidade2 = new ProdutoQuantidade(produto2, 10); 
        ArrayList<ProdutoQuantidade> produtos = new ArrayList<> ();  
        produtos.add(produtoQuantidade);
        produtos.add(produtoQuantidade2);
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produtos, TipoTransacao.VENDA); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
	}

}

