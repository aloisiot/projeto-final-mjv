package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.model.entity.Endereco;
import edu.mjv.school.projetofinal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends TemplateCrudService<Endereco> {

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
