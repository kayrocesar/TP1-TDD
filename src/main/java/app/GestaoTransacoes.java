package app;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.TipoTransacao;
import model.Produto;
import model.Transacao;

public class GestaoTransacoes {
	
	private ArrayList<Transacao> transacoes; 
	
	public GestaoTransacoes() {
		this.transacoes = new ArrayList<>(); 
		
	}
	
    public int getQuantidadeTransacao() {
		return this.transacoes.size(); 
    }

    public void cadastrarTransacao(LocalDate data, Produto produto, TipoTransacao tipoTransacao) {
    	Transacao transacao = new Transacao(data, produto, tipoTransacao); 
    	this.transacoes.add(transacao); 
    }
   
}
