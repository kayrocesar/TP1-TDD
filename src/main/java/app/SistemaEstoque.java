package app;

import Exceptions.DescricaoEmBrancoException;
import model.Produto;
import model.Transacao;


import java.util.ArrayList;

public class SistemaEstoque {

    private final ArrayList<Produto> produtos;


    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) throws DescricaoEmBrancoException {
        throw  new DescricaoEmBrancoException("Campo não pode ficar vazio!");
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

}