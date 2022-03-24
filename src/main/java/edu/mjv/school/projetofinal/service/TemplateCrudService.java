package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.exception.RepositorioVazioException;
import edu.mjv.school.projetofinal.exception.RecursoNaoEncontradoException;
import edu.mjv.school.projetofinal.exception.EntidadeImprocessavelException;
import edu.mjv.school.projetofinal.model.entity.DataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class TemplateCrudService<T extends DataBaseEntity> {

    protected final JpaRepository<T, Long> repository;

    public TemplateCrudService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T salvar(T entity) throws EntidadeImprocessavelException {
        if(entity.getId() != null){
            throw new EntidadeImprocessavelException("o parametro id nao deve ser especificado");
        }
        return repository.save(entity);
    }

    public T atualizar(T entity) throws RecursoNaoEncontradoException {
        if(entity.getId() != null && repository.existsById(entity.getId())){
            return repository.save(entity);
        }
        throw new RecursoNaoEncontradoException();
    }

    public T buscarPorId(Long id) throws RecursoNaoEncontradoException {
        Optional<T> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return entity.get();
    }

    public List<T> BuscarTodos() throws RepositorioVazioException {
        if(repository.count() == 0) {
            throw new RepositorioVazioException();
        }
        return repository.findAll();
    }

    public void deletarPorId(Long id) throws RecursoNaoEncontradoException {
        if(! repository.existsById(id)){
            throw new RecursoNaoEncontradoException();
        }
        repository.deleteById(id);
    }
}
