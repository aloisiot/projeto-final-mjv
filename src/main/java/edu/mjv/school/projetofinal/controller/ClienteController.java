package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Cliente;
import edu.mjv.school.projetofinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes", produces = "application/json;charset=UTF-8")
public class ClienteController extends TemplateCrudController<Cliente> {

    @Autowired
    public ClienteController(ClienteService service) {
        super(service);
    }
}
