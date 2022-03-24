package edu.mjv.school.projetofinal.model.embeddable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class QtdProdutoPorPedido {
    @NotNull
    private Long ProdutoId;

    @NotNull
    @Positive
    private Integer quantidadePorPedido;

    public Long getProdutoId() {
        return ProdutoId;
    }

    public void setProdutoId(Long produtoId) {
        ProdutoId = produtoId;
    }

    public Integer getQuantidadePorPedido() {
        return quantidadePorPedido;
    }

    public void setQuantidadePorPedido(Integer quantidadePorPedido) {
        this.quantidadePorPedido = quantidadePorPedido;
    }
}
