package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.model.entity.Funcionario;
import edu.mjv.school.projetofinal.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends TemplateCrudService<Funcionario> {

    @Autowired
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }
}
