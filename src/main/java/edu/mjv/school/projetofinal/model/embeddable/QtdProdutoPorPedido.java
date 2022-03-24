package edu.mjv.school.projetofinal.model.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
@Getter
@Setter
public class QtdProdutoPorPedido {
    @NotNull
    private Long ProdutoId;

    @NotNull
    @Positive
    private Integer quantidadePorPedido;
}
