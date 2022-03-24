package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Endereco;
import edu.mjv.school.projetofinal.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enderecos", produces = "application/json;charset=UTF-8")
public class EnderecoController extends TemplateCrudController<Endereco> {

    @Autowired
    public EnderecoController(EnderecoService service) {
        super(service);
    }
}
