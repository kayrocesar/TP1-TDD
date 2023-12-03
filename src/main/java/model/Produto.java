package model;

import enums.Categoria;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {

    private String nome;
    private String descricao;
    private String codigoBarras;
    private Double custo;
    private Double precoVenda;
    private Integer qtd;
    private Integer qtdMinima;

    private LocalDate dataVencimento;
    private Integer lote;

    private Categoria categoria;

    private Fornecedor fornecedor;


    public Produto(
            String nome,
            String descricao,
            String codigoBarras,
            Double custo,
            Double precoVenda,
            Integer qtd,
            Integer qtdMinima,
            LocalDate dataVencimento,
            Integer lote,
            Categoria categoria,
            Fornecedor fornecedor)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.qtd = qtd;
        this.qtdMinima = qtdMinima;
        this.dataVencimento = dataVencimento;
        this.lote = lote;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Integer getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(Integer qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "\nProduto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                "\n, codigoBarras='" + codigoBarras + '\'' +
                ", custo=" + custo +
                "\n, precoVenda=" + precoVenda +
                ", qtd=" + qtd +
                ", qtdMinima=" + qtdMinima +
                ", dataVencimento=" + dataVencimento +
                ", lote=" + lote +
                "\n, categoria=" + categoria +
                "\n, fornecedor=" + fornecedor +
                '}';
    }
}
