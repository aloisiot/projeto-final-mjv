package edu.mjv.school.projetofinal.model.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Log {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
