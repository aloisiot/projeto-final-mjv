package edu.mjv.school.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Log log;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MeioPagamento meioPagamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MeioCompra meioCompra;

    @ManyToMany
    private List<Produto> produtos;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Cliente cliente;
}
