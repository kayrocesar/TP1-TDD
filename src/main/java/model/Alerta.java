package model;

import Exceptions.EstoqueNegativoException;

public class Alerta {
    public Alerta(){}

    public void validarQuantidadeEstoqueProduto(Produto produto) throws EstoqueNegativoException{
        if(produto.getQtd() < 0)
        {
            throw new EstoqueNegativoException("Estoque negativo");
        }
        if(produto.getQtd() <= produto.getQtdMinima()){
            emitirAlerta(produto);
        }
    }

    public void emitirAlerta(Produto produto){
        System.out.printf("Produto %s atingiu %d no estoque.\n A quantidade mínima é %d\nFornecedor : %s",
                produto.getNome(),
                produto.getQtd(),
                produto.getQtdMinima(),
                produto.getFornecedor().getNome());
    }
}
