package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.exception.EmpityRepositoryExceprion;
import edu.mjv.school.projetofinal.exception.ResorceNotFoundException;
import edu.mjv.school.projetofinal.exception.UnprocessableEntityException;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto){
        if(produto.getId() != null) {
            throw new UnprocessableEntityException("Id nao deve ser expecificado");
        }
        return repository.save(produto);
    }

    public Produto atualizar(Produto produto) {
        if(! repository.existsById(produto.getId())) {
            throw new ResorceNotFoundException("registro de produto nao encontrado");
        }
        return repository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()) {
            throw new ResorceNotFoundException("registro de produto nao encontrado");
        }
        return produto.get();
    }

    public List<Produto> buscarTodos() {
        List<Produto> produtos = repository.findAll();
        if(produtos.isEmpty()) {
            throw new EmpityRepositoryExceprion("nao ha produtos registrados");
        }
        return produtos;
    }

    public void deletar (Long id) {
        if(! repository.existsById(id)) {
            throw new ResorceNotFoundException("registro de produto nao encontrado");
        }
        repository.deleteById(id);
    }
}
