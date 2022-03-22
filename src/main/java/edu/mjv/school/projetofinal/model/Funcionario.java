package edu.mjv.school.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
public class Funcionario extends Pessoa {

    @Enumerated(EnumType.STRING)
    @Embedded
    @Column(nullable = false, length = 30)
    private FuncaoFuncionario funcao;

    @Column(nullable = false)
    private BigInteger salario;

    @Column(nullable = false)
    private Boolean ativo;
}
