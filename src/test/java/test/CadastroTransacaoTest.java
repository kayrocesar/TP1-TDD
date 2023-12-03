package test;

import app.GestaoTransacoes;
import enums.*;
import model.Fornecedor;
import model.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produto1, TipoTransacao.VENDA); 
		assertEquals(gestao.getQuantidadeTransacao(), 1); 
	}
	
	@Test
	public void testCadastroDuasTransacao() { 
        Produto produto1 = new Produto("Iogurte Grego",
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
        LocalDate date = LocalDate.now(); 
		gestao.cadastrarTransacao(date, produto1, TipoTransacao.VENDA); 
		assertEquals(gestao.getQuantidadeTransacao(), 2); 
	}

}

