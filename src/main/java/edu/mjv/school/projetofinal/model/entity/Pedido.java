package edu.mjv.school.projetofinal.model.entity;

import edu.mjv.school.projetofinal.model.embeddable.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido extends DataBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Log log;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "Campo salario nao pode ser nulo")
    private StatusPedido status;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "Campo 'meioPagamento' nao pode ser nulo")
    private MeioPagamento meioPagamento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo 'meioCompra' nao pode ser nulo")
    private MeioCompra meioCompra;

    @ManyToMany
    @NotEmpty(message = "Um pedido deve conter no minimo um produto")
    private List<Produto> produtos;

    @Embedded
    @NotNull
    @ElementCollection(fetch = FetchType.EAGER)
    private List<QtdProdutoPorPedido> qtdProdutoPorPedido;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Cliente cliente;

    private Long enderecoEntregaId;
}
