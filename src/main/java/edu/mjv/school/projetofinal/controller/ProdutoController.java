package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos", produces = "application/json;charset=UTF-8")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um produto com base no ID")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Salvar (criar) produto")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(produto));
    }

    @PutMapping
    @Operation(summary = "Atualizar um produto")
    public ResponseEntity<Produto> atualizar (@RequestBody Produto produto) {
        return ResponseEntity.ok(service.atualizar(produto));
    }

    @GetMapping
    @Operation(summary = "Buscar todos os produtos")
    public ResponseEntity<List<Produto>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um produto com base no ID")
    public ResponseEntity<?> deletarPorId (@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
