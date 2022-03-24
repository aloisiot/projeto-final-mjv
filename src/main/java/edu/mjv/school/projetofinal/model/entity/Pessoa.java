package edu.mjv.school.projetofinal.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public abstract class Pessoa extends DataBaseEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private  String nome;

    @Column(length = 11, nullable = false)
    @Pattern(regexp = "[0-9]{11}", message = "CPF deve conter apenas numeros")
    private  String cpf;

    @Column(nullable = false)
    private  String rg;

    @Column(length = 12)
    private  String telefone;

    @Email
    private  String email;

    @Temporal(TemporalType.DATE)
    private Calendar dataNaciento;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Endereco> enderecos;
}
