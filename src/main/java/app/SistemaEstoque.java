package app;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import model.Produto;
import model.Transacao;


import java.util.ArrayList;

public class SistemaEstoque {

    private final ArrayList<Produto> produtos;


    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) throws DescricaoEmBrancoException , ValorInvalidoException {

        if (produto.getNome().isBlank() || produto.getDescricao().isBlank() || produto.getCodigoBarras().isBlank() || produto.getCusto().isNaN()
                || produto.getPrecoVenda().isNaN() || (produto.getQtd() == null) || (produto.getQtdMinima() == null) || (produto.getDataVencimento() == null)
                || (produto.getLote() == null) || (produto.getCategoria() == null) || (produto.getFornecedor() == null)) {
            throw new DescricaoEmBrancoException("Campo não pode ficar vazio!");
        }
        if( produto.getCusto() == 0.0){
            throw new ValorInvalidoException("Valor não pode ser inferior ou igual a zero!");
        }
        this.produtos.add(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

}