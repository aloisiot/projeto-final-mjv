package edu.mjv.school.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 2, nullable = false)
    private String uf;
}
