package app;

import java.time.LocalDate;
import java.util.ArrayList;

import Exceptions.ValorInvalidoException;
import enums.TipoTransacao;
import model.ProdutoQuantidade;
import model.Transacao;

public class GestaoTransacoes {
	
	private ArrayList<Transacao> transacoes; 
	
	public GestaoTransacoes() {
		this.transacoes = new ArrayList<>(); 
	}
	
	public ArrayList<Transacao> getTransacoes(){
		return transacoes; 	
	}
	
	public Transacao getUltimaTransacao() {
		return this.transacoes.get(this.transacoes.size()-1); 
	}
	
    public int getQuantidadeTransacao() {
		return this.transacoes.size(); 
    }

    public void cadastrarTransacao(LocalDate data, ArrayList<ProdutoQuantidade> produtos, TipoTransacao tipoTransacao) {
    	Transacao transacao = new Transacao(data, produtos, tipoTransacao); 
    	atualizarEstoque(transacao); 
    	this.transacoes.add(transacao); 
    }
    
    public void cadastrarTransacao(Transacao transacao) {
    	atualizarEstoque(transacao);
    	this.transacoes.add(transacao);
    }
   
    public void atualizarEstoque(Transacao transacao) {
    	if(transacao.getTipoTransacao() == TipoTransacao.VENDA) {
	    	for(ProdutoQuantidade elemento: transacao.getProdutos()) {
	    		elemento.getProduto().diminuirQtd(elemento.getQuantidade());
	    	}
    	}
    	else {
	    	for(ProdutoQuantidade elemento: transacao.getProdutos()) {
	    		elemento.getProduto().adicionarQtd(elemento.getQuantidade());
    	}
    
    	}
    }
    
    public void validarTransacao(Transacao transacao) throws ValorInvalidoException{
    	for (ProdutoQuantidade produtoQtd : transacao.getProdutos()) {
			if(produtoQtd.getQuantidade() < 0) {
				throw new ValorInvalidoException("O valor da transacao não pode ser negativo para não ajustes.");
			}    			
		}
    }
    
}
