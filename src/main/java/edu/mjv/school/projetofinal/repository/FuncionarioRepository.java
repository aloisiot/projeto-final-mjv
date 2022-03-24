package edu.mjv.school.projetofinal.repository;

import edu.mjv.school.projetofinal.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}