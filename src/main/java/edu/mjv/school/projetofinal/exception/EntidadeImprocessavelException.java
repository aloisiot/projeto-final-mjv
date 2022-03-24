package edu.mjv.school.projetofinal.exception;


public class EntidadeImprocessavelException extends RuntimeException {
    public EntidadeImprocessavelException() {
        super("Entidade improcessavel. Verifique os dados enviados");
    }

    public EntidadeImprocessavelException(String message) {
        super(message);
    }
}
