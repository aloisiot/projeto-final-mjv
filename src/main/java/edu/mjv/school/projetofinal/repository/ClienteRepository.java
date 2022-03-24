package edu.mjv.school.projetofinal.repository;

import edu.mjv.school.projetofinal.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}