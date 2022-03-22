package edu.mjv.school.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String nome;

    @Column(length = 11, nullable = false)
    private  String cpf;

    @Column(nullable = false)
    private  String rg;

    @Column(length = 12)
    private  String telefone;

    @Email
    private  String email;

    @Temporal(TemporalType.DATE)
    private Calendar dataNaciento;

    @OneToMany
    private List<Endereco> enderecos;
}
