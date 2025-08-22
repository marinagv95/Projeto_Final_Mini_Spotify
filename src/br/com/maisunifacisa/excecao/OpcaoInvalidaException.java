package br.com.maisunifacisa.excecao;

public class OpcaoInvalidaException extends RuntimeException {
    public OpcaoInvalidaException(String message) {
        super(message);
    }
}
