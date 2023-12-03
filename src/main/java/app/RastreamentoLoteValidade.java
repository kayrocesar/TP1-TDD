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
    public boolean emiteAlertLoteVencimento(ArrayList<Produto> produtos, Integer qdtLotesDiferentes) {
        System.out.println("Atenção o lote " + produtos.get(0).getLote() + " com validade "
                + produtos.get(0).getDataVencimento() + " está próximo ao vencimento, o preço de venda foi atualizado de R$"
                + produtos.get(0).getPrecoVenda() + " para R$" +produtos.get(0).getPrecoVenda()*0.8 );
        return  true;
    }
}
