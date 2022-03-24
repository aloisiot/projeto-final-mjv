package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Produto;
import edu.mjv.school.projetofinal.service.ProdutoService;
import edu.mjv.school.projetofinal.service.TemplateCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/produtos", produces = "application/json;charset=UTF-8")
public class ProdutoController extends TemplateCrudController<Produto> {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(TemplateCrudService<Produto> service) {
        super(service);
        this.service = (ProdutoService) super.service;
    }

    @GetMapping("/palavra-chave/{palavraChave}")
    @Operation(summary = "Buscar produto com base em uma palavra chave")
    public ResponseEntity<Set<Produto>> buscarPorPalavraChave(@PathVariable String palavraChave) {
        return ResponseEntity.ok(service.buscarPorPalavraChave(palavraChave));
    }
}
