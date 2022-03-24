package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Pedido;
import edu.mjv.school.projetofinal.service.PedidoService;
import edu.mjv.school.projetofinal.service.TemplateCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos", produces = "application/json;charset=UTF-8")
public class PedidoController extends TemplateCrudController<Pedido> {

    @Autowired
    public PedidoController(TemplateCrudService<Pedido> service) {
        super(service);
    }

    @GetMapping("/por-funcionario/{funcionarioId}")
    @Operation(summary = "Buscar todos os pedidos com base no funcionario responsavel")
    public ResponseEntity<List<Pedido>> buscarPorFuncionarioId(@PathVariable Long funcionarioId) {
        PedidoService service = (PedidoService) super.service;
        return ResponseEntity.ok(service.buscarPorFuncionarioId(funcionarioId));
    }

    @GetMapping("/por-cliente/{clienteId}")
    @Operation(summary = "Buscar todos os pedidos com base no cliente")
    public ResponseEntity<List<Pedido>> buscarPorClienteId(@PathVariable Long clienteId) {
        PedidoService service = (PedidoService) super.service;
        return ResponseEntity.ok(service.buscarPorClienteId(clienteId));
    }
}
