package edu.mjv.school.projetofinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Endereco extends DataBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Campo logradouro nao pode ser nulo")
    private String logradouro;

    @Column(nullable = false)
    @NotNull(message = "Campo numero nao pode ser nulo")
    private Integer numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100, nullable = false)
    @NotNull(message = "Campo numero nao pode ser nulo")
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 8, nullable = false)
    @Pattern(regexp = "[0-9]{8}", message = "CEP deve conter apenas numeros")
    @NotNull(message = "Campo cep nao pode ser nulo")
    private String cep;

    @Column(length = 2, nullable = false)
    @NotNull(message = "Campo uf nao pode ser nulo")
    private String uf;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
