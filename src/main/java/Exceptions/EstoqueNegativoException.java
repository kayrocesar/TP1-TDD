package Exceptions;

public class EstoqueNegativoException extends Exception{
    public EstoqueNegativoException(String mensagemDeErro){
        super(mensagemDeErro);
    }
}
