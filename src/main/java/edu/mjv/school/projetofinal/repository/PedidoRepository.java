package edu.mjv.school.projetofinal.repository;

import edu.mjv.school.projetofinal.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("select p from Pedido p where p.cliente.id = :id")
    List<Pedido> findByClienteId(@Param("id") Long id);

    @Query("select p from Pedido p where p.funcionario.id = :Id")
    List<Pedido> findByFuncionarioId(@Param("Id") Long Id);
}