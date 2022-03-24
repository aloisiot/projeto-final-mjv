package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.exception.RepositorioVazioException;
import edu.mjv.school.projetofinal.exception.RecursoNaoEncontradoException;
import edu.mjv.school.projetofinal.exception.EntidadeImprocessavelException;
import edu.mjv.school.projetofinal.model.entity.DataBaseEntity;
import edu.mjv.school.projetofinal.service.TemplateCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class TemplateCrudController<T extends DataBaseEntity> {

    protected final TemplateCrudService<T> service;

    public TemplateCrudController(TemplateCrudService<T> service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Registrar nova entidade")
    public ResponseEntity<T> salvar (@RequestBody T entity) throws EntidadeImprocessavelException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(entity));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entidade com base no ID")
    public ResponseEntity<T> buscarPorId(@PathVariable Long id) throws RecursoNaoEncontradoException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Buscar todas as entidades")
    public ResponseEntity<List<T>> BuscarTodos() throws RepositorioVazioException {
        return ResponseEntity.ok(service.BuscarTodos());
    }

    @PutMapping
    @Operation(summary = "Atualizar entidade")
    public ResponseEntity<T> atualizar(@RequestBody T entity) throws RecursoNaoEncontradoException {
        return ResponseEntity.ok(service.atualizar(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar entidade com base no ID")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) throws RecursoNaoEncontradoException {
        service.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
