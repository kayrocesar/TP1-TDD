package model;

import Exceptions.EstoqueNegativoException;

public class Alerta {
    public Alerta(){}

    public void validarQuantidadeEstoqueProduto(Produto produto) throws EstoqueNegativoException{
        throw new EstoqueNegativoException("Estoque negativo");
    }

    public void emitirAlerta(Produto produto){
        System.out.println("Produto atingiu quantidade mínima");
    }
}
