package edu.mjv.school.projetofinal.repository;

import edu.mjv.school.projetofinal.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("select p from Produto p where upper(p.descricao) like upper(concat('%', :substring, '%'))")
    List<Produto> findByDescricaoIgnoreCaseLike(@Param("substring") String substring);

    @Query("select p from Produto p where upper(p.nome) like upper(concat('%', :substring, '%'))")
    List<Produto> findByNomeIgnoreCaseLike(@Param("substring") String substring);
}
