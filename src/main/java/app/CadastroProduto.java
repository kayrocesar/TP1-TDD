package app;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import model.Produto;


import java.util.ArrayList;

public class CadastroProduto {

    private final ArrayList<Produto> produtos;


    public CadastroProduto() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) throws DescricaoEmBrancoException, ValorInvalidoException {

        if (produto.getNome().isBlank() || produto.getDescricao().isBlank() || produto.getCodigoBarras().isBlank() || produto.getCusto().isNaN() ||
                produto.getPrecoVenda().isNaN() || produto.getCategoria() == null || produto.getFornecedor() == null) {
            throw new DescricaoEmBrancoException("Nenhum campo pode estar vazio!");
        }
        if (produto.getCusto() <= 0.0 || produto.getPrecoVenda() <= 0.0 || produto.getQtd() <= 0 || produto.getQtdMinima() <= 0) {
            throw new ValorInvalidoException("Valor não pode ser inferior ou igual a zero!");
        }

        this.produtos.add(produto);

    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

}