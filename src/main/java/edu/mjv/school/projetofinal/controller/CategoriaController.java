package edu.mjv.school.projetofinal.controller;

import edu.mjv.school.projetofinal.model.entity.Categroia;
import edu.mjv.school.projetofinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias", produces = "application/json;charset=UTF-8")
public class CategoriaController extends TemplateCrudController<Categroia> {

    @Autowired
    public CategoriaController(CategoriaService service) {
        super(service);
    }
}
