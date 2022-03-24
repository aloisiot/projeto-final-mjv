package edu.mjv.school.projetofinal.model.entity;

import edu.mjv.school.projetofinal.model.embeddable.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public MeioCompra getMeioCompra() {
        return meioCompra;
    }

    public void setMeioCompra(MeioCompra meioCompra) {
        this.meioCompra = meioCompra;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<QtdProdutoPorPedido> getQtdProdutoPorPedido() {
        return qtdProdutoPorPedido;
    }

    public void setQtdProdutoPorPedido(List<QtdProdutoPorPedido> qtdProdutoPorPedido) {
        this.qtdProdutoPorPedido = qtdProdutoPorPedido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getEnderecoEntregaId() {
        return enderecoEntregaId;
    }

    public void setEnderecoEntregaId(Long enderecoEntregaId) {
        this.enderecoEntregaId = enderecoEntregaId;
    }
}
