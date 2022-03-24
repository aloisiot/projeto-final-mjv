package edu.mjv.school.projetofinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categroia extends DataBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70, unique = true)
    @NotNull(message = "Campo nome nao pode ser nulo")
    private String nome;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
