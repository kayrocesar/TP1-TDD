package test;

import app.GestaoTransacoes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CadastroTransacaoTest {
	
	private GestaoTransacoes gestao;
	
	@BeforeEach
	public void setup() {
		gestao = new GestaoTransacoes(); 
	}
		
	@Test
	public void testCadastroTransacao() { 
		gestao.cadastrarTransacao(); 
		System.out.print(gestao.getQuantidadeTransacao());
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
	}

}

