package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Funcionario;
import edu.mjv.school.projetofinal.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcionarios", produces = "application/json;charset=UTF-8")
public class FuncionarioController extends TemplateCrudController<Funcionario> {

    @Autowired
    public FuncionarioController(FuncionarioService service) {
        super(service);
    }
}
