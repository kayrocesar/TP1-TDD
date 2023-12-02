package app;

import model.Produto;
import model.Transacao;

import java.util.ArrayList;

public class SistemaEstoque {

    private final ArrayList<Produto> produtos;

    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto){
        this.produtos.add(produto);
    }

    public ArrayList<Produto> getProdutos()
    {
        return this.produtos;
    }
}