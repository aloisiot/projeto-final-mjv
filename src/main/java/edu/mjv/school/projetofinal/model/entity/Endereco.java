package edu.mjv.school.projetofinal.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Endereco extends DataBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Campo logradouro nao pode ser nulo")
    private String logradouro;

    @Column(nullable = false)
    @NotNull(message = "Campo numero nao pode ser nulo")
    private Integer numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100, nullable = false)
    @NotNull(message = "Campo numero nao pode ser nulo")
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 8, nullable = false)
    @Pattern(regexp = "[0-9]{8}", message = "CEP deve conter apenas numeros")
    @NotNull(message = "Campo cep nao pode ser nulo")
    private String cep;

    @Column(length = 2, nullable = false)
    @NotNull(message = "Campo uf nao pode ser nulo")
    private String uf;
}
