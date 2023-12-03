package model;

public class ConsultaEstoque {

    public String consultarEstoque(Produto produto) {
        return produto.getNome() + ": " + produto.getQtd();
    }
}
