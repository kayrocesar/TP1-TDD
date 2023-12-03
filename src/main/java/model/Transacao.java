package model;


import enums.TipoTransacao;
import model.ProdutoQuantidade; 

import java.time.LocalDate;
import java.util.ArrayList;


public  class Transacao {
    private LocalDate data;
    private ArrayList<ProdutoQuantidade> produtos; 
    private TipoTransacao tipoTransacao;

    public Transacao(LocalDate data, ArrayList<ProdutoQuantidade> produtos, TipoTransacao tipoTransacao) {
        this.data = data;
        this.produtos = produtos;
        this.tipoTransacao = tipoTransacao;
    }
    
    public Transacao() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto, int quantidade) {
    	ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto, quantidade); 
        this.produtos.add(produtoQuantidade);
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    
    public String listarProdutos() {
    	String todos_produtos = ""; 
    	for(ProdutoQuantidade elemento: this.produtos) {
    		todos_produtos += "Produto: " + elemento.getProduto().getNome() + " Quantidade: " + elemento.getQuantidade() + "\n";  
    		
    	}
    	return todos_produtos; 
    }
    
    @Override
    public String toString() {
        return "Transacao{" +
                "data =" + data +
                ", produto =" + this.listarProdutos() +
                ", tipoTransacao =" + tipoTransacao +
                '}';
    }
}
