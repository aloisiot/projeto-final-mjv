package edu.mjv.school.projetofinal.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Produto extends DataBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String nome;

    @Column(nullable = false, length = 500)
    @Size(min = 10, max = 500, message = "A descricao devee conter entre 10 e 500 caracters")
    private String descricao;

    @ManyToOne
    @NotNull(message = "Categoria nao pode ser nulo")
    private Categroia categroia;

    @Column(nullable = false)
    @PositiveOrZero(message = "A quantidade de produtos em estoque não pode ser negativa")
    private Integer quantidadeEstoque;

    @Column(nullable = false)
    @Positive(message = "O preco deve ser positivo")
    @NotNull(message = "Campo preco nao deve ser nulo")
    private BigDecimal preco;
}
