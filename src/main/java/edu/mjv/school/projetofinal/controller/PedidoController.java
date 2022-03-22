package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.Pedido;
import edu.mjv.school.projetofinal.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos", produces = "application/json;charset=UTF-8")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um pedido com base no ID")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Salvar (criar) pedido")
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pedido));
    }

    @PutMapping
    @Operation(summary = "Atualizar um pedido")
    public ResponseEntity<Pedido> atualizar (@RequestBody Pedido pedido) {
        return ResponseEntity.ok(service.atualizar(pedido));
    }

    @GetMapping
    @Operation(summary = "Buscar todos os pedidos")
    public ResponseEntity<List<Pedido>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um pedido com base no ID")
    public ResponseEntity<?> deletarPorId (@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/por-funcionario/{funcionarioId}")
    @Operation(summary = "Buscar todos os pedidos com base no funcionario responsavel")
    public ResponseEntity<List<Pedido>> buscarPorFuncionarioId(@PathVariable Long funcionarioId) {
        return ResponseEntity.ok(service.buscarPorFuncionaioId(funcionarioId));
    }

    @GetMapping("/por-cliente/{clienteId}")
    @Operation(summary = "Buscar todos os pedidos com base no cliente")
    public ResponseEntity<List<Pedido>> buscarPorClienteId(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.buscarPorClienteId(clienteId));
    }
}
