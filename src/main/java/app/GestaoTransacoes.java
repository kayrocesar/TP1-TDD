package app;

import java.time.LocalDate;
import java.util.ArrayList;

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
    	this.transacoes.add(transacao); 
    }
   
}
