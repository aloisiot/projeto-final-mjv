package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.model.entity.Categroia;
import edu.mjv.school.projetofinal.repository.CategroiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends TemplateCrudService<Categroia> {

    @Autowired
    public CategoriaService(CategroiaRepository repository) {
        super(repository);
    }
}
