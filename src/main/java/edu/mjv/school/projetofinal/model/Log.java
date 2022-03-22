package edu.mjv.school.projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Embeddable
@Getter
@Setter
public class Log {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dataRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAtualizacao;
}
