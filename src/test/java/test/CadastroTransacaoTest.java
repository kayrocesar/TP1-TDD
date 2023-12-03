package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.GestaoTransacoes;
import enums.Categoria;
import enums.TipoTransacao;
import model.Fornecedor;
import model.Produto;
import model.ProdutoQuantidade;
import model.Transacao;

class CadastroTransacaoTest {
	
	private GestaoTransacoes gestao;
//	
//	@ParameterizedTest
//	@MethodSource()
	
	
	@BeforeEach
	public void setup() {
		gestao = new GestaoTransacoes(); 
	}
	
	@Test
	public void testCadastroNegativoTransacao() {
		Transacao transacao = new Transacao();
		assertEquals(gestao.getQuantidadeTransacao(), 1);
		assertNotEquals(transacao.getTipoTransacao(), TipoTransacao.AJUSTE);
		for (ProdutoQuantidade produtoQuantidade : transacao.getProdutos()) {
			ProdutoQuantidade produtoQtd = new ProdutoQuantidade(produtoQuantidade.getProduto() , result);
			
			assertTrue(produtoQtd.getQuantidade() > produtoQtd.getProduto().getQtd());
		}
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
               new Fornecedor("Brasal Refrigerantes LTDA", "60.444.444/0001-48"));
        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto1, 2); 
        ArrayList<ProdutoQuantidade> produtos = new ArrayList<> ();  
        produtos.add(produtoQuantidade);
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produtos, TipoTransacao.VENDA); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
		assertEquals(produto1.getQtd(), 48); 
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
               "3153255413",
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
		gestao.cadastrarTransacao(date, produtos, TipoTransacao.DEVOLUCAO); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
		assertEquals(produto1.getQtd(), 52);
		assertEquals(produto2.getQtd(), 40);
	}

	@Test
	public void testCadastroTresTransacao() { 
        Produto produto1 = new Produto("Chocolate meio amargo LACTA",
                "Barra de chocolate da LACTA sabor meio amargo",
               "271462742",
               3.0,
               6.0,
               60,
               2,
               LocalDate.of(2023,12,3),
               1,
               Categoria.CHOCOLATE,
               new Fornecedor("Brasal Refrigerantes LTDA", "42.679.040/0001-51"));
        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto1, 100); 
        ArrayList<ProdutoQuantidade> produtos = new ArrayList<> ();  
        produtos.add(produtoQuantidade);
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produtos, TipoTransacao.CADASTRO); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
		assertEquals(produto1.getQtd(), 160); 
		
	}
}

