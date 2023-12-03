package Exceptions;

public class ValorInvalidoException extends Exception{
    public ValorInvalidoException(String mensagemDeErro){
        super(mensagemDeErro);
    }
}