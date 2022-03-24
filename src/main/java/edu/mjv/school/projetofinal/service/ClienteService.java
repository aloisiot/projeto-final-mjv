package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.model.entity.Cliente;
import edu.mjv.school.projetofinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends TemplateCrudService<Cliente> {

    @Autowired
    public ClienteService(ClienteRepository repository) {
        super(repository);
    }
}
