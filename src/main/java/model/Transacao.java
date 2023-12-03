package model;


import enums.TipoTransacao;

import java.time.LocalDate;


public  class Transacao {
    private LocalDate data;
    private Produto produto;
    private TipoTransacao tipoTransacao;

    public Transacao(LocalDate data, Produto produto, TipoTransacao tipoTransacao) {
        this.data = data;
        this.produto = produto;
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    
    @Override
    public String toString() {
        return "Transacao{" +
                "data =" + data +
                ", produto =" + produto +
                ", tipoTransacao =" + tipoTransacao +
                '}';
    }
}
