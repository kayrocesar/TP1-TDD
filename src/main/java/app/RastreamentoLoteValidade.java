package app;

import model.Produto;

import java.util.ArrayList;

public class RastreamentoLoteValidade {

    public  Integer quantidadeTotalProduto(Produto produto){
        return produto.getQtd();
    }
    public Integer quantidadeTotalProdutoLote(ArrayList<Produto> produtos, Integer numeroLote){
        Integer total=0;
        for (Produto produto: produtos){
            if (produto.getLote().equals(numeroLote)){
                total+=produto.getQtd();
            }

        }
        return total;
    }

}
