package edu.mjv.school.projetofinal.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException() {
        super("recurso nao encontrado");
    }

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }
}