package edu.mjv.school.projetofinal.model.entity;

import edu.mjv.school.projetofinal.model.embeddable.FuncaoFuncionario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Funcionario extends Pessoa {

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "Campo funcao nao pode ser nulo")
    private FuncaoFuncionario funcao;

    @Column(nullable = false)
    @NotNull(message = "Campo salario nao pode ser nulo")
    private BigDecimal salario;

    @Column(nullable = false)
    @NotNull(message = "Campo ativo nao pode ser nulo")
    private Boolean ativo;

    public FuncaoFuncionario getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoFuncionario funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
