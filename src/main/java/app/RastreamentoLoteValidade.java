package app;

import model.Produto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
        Boolean controle=false;
        ArrayList<Boolean> lotesProximosVencimento = new ArrayList<>(Collections.nCopies(qdtLotesDiferentes, false));
        LocalDate dataAtual = LocalDate.now();

        for (Produto produto: produtos){
            Boolean proximoAoVencimento =verificarDistanciaDias(dataAtual,produto.getDataVencimento(),10);
            if (proximoAoVencimento){
                lotesProximosVencimento.set(produto.getLote() - 1, true);
                produto.setPrecoVenda(produto.getPrecoVenda()*0.8);
                System.out.println("Atenção o produto " + produto.getNome() + " com validade "
                + produto.getDataVencimento() + " está próximo ao vencimento, o preço de venda foi atualizado de R$"
                + produto.getPrecoVenda()*1.25 + " para R$" +produto.getPrecoVenda()+ "\n");
            }
        }
        for (int i=0; i <lotesProximosVencimento.size(); i++){
            if (lotesProximosVencimento.get(i).equals(true)){
                System.out.println("Os preços dos itens do lote "+ (i+1) +
                        " foram atualizados com um desconto de 20%, pois estavam próximos à data de vencimento." );
                controle=true;
            }
        }

        return controle;

    }
    private boolean verificarDistanciaDias(LocalDate data1, LocalDate data2, long minDiasDeDiferenca) {
        long diferenca = Math.abs(ChronoUnit.DAYS.between(data1, data2));
        return diferenca <= minDiasDeDiferenca;

    }
}
