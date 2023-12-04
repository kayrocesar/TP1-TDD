package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import Exceptions.ValorInvalidoException;
import app.GestaoTransacoes;
import enums.Categoria;
import enums.TipoTransacao;
import model.Fornecedor;
import model.Produto;
import model.ProdutoQuantidade;
import model.Transacao;

class CadastroTransacaoTest {
	
	private GestaoTransacoes gestao;
	
	@BeforeEach
	public void setup() {
		gestao = new GestaoTransacoes(); 
	}
	
	static List<Produto> produtos = new ArrayList<Produto>(Arrays.asList(
			new Produto("Coca cola",
					"Coca cola de 2 litros sem acucar",
					"271462742",
					20.0,
					10.0,
					50,
					2,
					LocalDate.of(2023,12,1),
					1,
					Categoria.REFRIGERANTE,
					new Fornecedor("Brasal Refrigerantes LTDA", "60.444.444/0001-48")),
			new Produto("Iogurte Grego",
					"Iogurte Grego de Mousse de Limão",
					"3153255413",
					2.50,
					4.0,
					30,
					1,
					LocalDate.of(2023,12,22),
					1,
					Categoria.IOGURTE,
					new Fornecedor("ITALAC LTDA", "42.679.040/0001-51"))
	));
	
	@ParameterizedTest
	@MethodSource("transacoesNegativas")
	public void testCadastroNegativoTransacao(Transacao transacao) {
		assertThrows(ValorInvalidoException.class, () -> gestao.validarTransacao(transacao));
	}
	
	static Stream<Arguments> transacoesNegativas() {
        return Stream.of(
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), -10)
                		)), TipoTransacao.DEVOLUCAO )),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(0), -53),
                		new ProdutoQuantidade(produtos.get(1), -8)
                		)), TipoTransacao.VENDA )),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), -7),
                		new ProdutoQuantidade(produtos.get(0), -5)
                		)), TipoTransacao.CADASTRO ))
        );
	}
	
	@ParameterizedTest
	@MethodSource("transacoesPositivas")
	public void testCadastroTransacao(Transacao transacao, List<Integer> esperado) {
		gestao.cadastrarTransacao(transacao);
		assertEquals(gestao.getQuantidadeTransacao(), 1);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for (ProdutoQuantidade produtoQuantidade : transacao.getProdutos()) {
			produtos.add(produtoQuantidade.getProduto());
		}
		int i=0;
		for (Produto produto : produtos) {
			assertEquals(produto.getQtd(), esperado.get(i)); i++;
		}
	}
	
	static Stream<Arguments> transacoesPositivas() {
        return Stream.of(
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), 10)
                		)), TipoTransacao.VENDA ), Arrays.asList(20)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(0), 18),
                		new ProdutoQuantidade(produtos.get(1), 20)
                		)), TipoTransacao.VENDA ), Arrays.asList(32, 0)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(0), 2)
                		)), TipoTransacao.DEVOLUCAO ), Arrays.asList(34)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), 10),
                		new ProdutoQuantidade(produtos.get(0), 5)
                		)), TipoTransacao.DEVOLUCAO ), Arrays.asList(10, 39)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), 4)
                		)), TipoTransacao.DEVOLUCAO ), Arrays.asList(14)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(1), 25)
                		)), TipoTransacao.CADASTRO ), Arrays.asList(39)),
                Arguments.of(new Transacao(LocalDate.now(), new ArrayList<ProdutoQuantidade>(Arrays.asList(
                		new ProdutoQuantidade(produtos.get(0), 1)
                		)), TipoTransacao.CADASTRO ), Arrays.asList(40))
        );
	}
}

