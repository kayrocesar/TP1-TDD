package app;

import model.Produto;

import java.util.ArrayList;

public class RastreamentoLoteValidade {

    public  Integer quantidadeTotalProduto(Produto produto){
        return produto.getQtd();
    }
    public Integer quantidadeTotalProdutoLote(ArrayList<Produto> produtos, Integer numeroLote){
        return produtos.get(0).getQtd();
    }

}
