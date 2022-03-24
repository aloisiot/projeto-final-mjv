package edu.mjv.school.projetofinal.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Categroia extends DataBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70, unique = true)
    @NotNull(message = "Campo nome nao pode ser nulo")
    private String nome;
}
