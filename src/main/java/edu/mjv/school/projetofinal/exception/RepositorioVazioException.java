package edu.mjv.school.projetofinal.exception;

public class RepositorioVazioException extends RuntimeException {
    public RepositorioVazioException() {
        super("repositorio vazio");
    }

    public RepositorioVazioException(String message) {
        super(message);
    }
}
