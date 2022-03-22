package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.exception.EmpityRepositoryExceprion;
import edu.mjv.school.projetofinal.exception.ResorceNotFoundException;
import edu.mjv.school.projetofinal.exception.UnprocessableEntityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<?> unprocessableEntityHandler(Exception e) {
    return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() +"\"}");
    }

    @ExceptionHandler(ResorceNotFoundException.class)
    public ResponseEntity<?> resorceNotFoundHandler (Exception e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EmpityRepositoryExceprion.class)
    public ResponseEntity<?> empityRepositoryHandler(Exception e) {
        return ResponseEntity.noContent().build();
    }
}
