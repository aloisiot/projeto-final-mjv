package edu.mjv.school.projetofinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categroia getCategroia() {
        return categroia;
    }

    public void setCategroia(Categroia categroia) {
        this.categroia = categroia;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
