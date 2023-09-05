package br.edu.infnet.excecao;

public class SeguroNaoDisponivelException extends RuntimeException{
    public SeguroNaoDisponivelException(String message) {
        super(message);
    }
}
