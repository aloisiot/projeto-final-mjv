package edu.mjv.school.projetofinal.model.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class Log {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
