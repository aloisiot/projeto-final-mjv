package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.exception.RepositorioVazioException;
import edu.mjv.school.projetofinal.exception.RecursoNaoEncontradoException;
import edu.mjv.school.projetofinal.exception.EntidadeImprocessavelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.sql.SQLException;

@ControllerAdvice
public class ManipuladorGlobalDeExcecoes {

    @ExceptionHandler({
            EntidadeImprocessavelException.class,
            ValidationException.class,
            SQLException.class
    })
    public ResponseEntity<?> entidadeImprocessavelHandler(Exception e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("{\"error\": \"" + e.getMessage() +"\"}");
    }

    @ExceptionHandler({RecursoNaoEncontradoException.class, RepositorioVazioException.class})
    public ResponseEntity<?> recursoNaoEncontradoHandler (Exception e) {
        return ResponseEntity.noContent().build();
    }
}
