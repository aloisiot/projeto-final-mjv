package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.exception.RecursoNaoEncontradoException;
import edu.mjv.school.projetofinal.model.entity.Produto;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProdutoService extends TemplateCrudService<Produto> {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        super(repository);
        this.repository = (ProdutoRepository) super.repository;
    }

    public Set<Produto> buscarPorPalavraChave(String palavraChave) {
        Set<Produto> produtos = new HashSet<>();
        produtos.addAll(repository.findByNomeIgnoreCaseLike(palavraChave));
        produtos.addAll(repository.findByDescricaoIgnoreCaseLike(palavraChave));

        if(produtos.isEmpty()) {
            throw new RecursoNaoEncontradoException("nenhum produto corespondente a palavra chave");
        }

        return produtos;
    }
}
