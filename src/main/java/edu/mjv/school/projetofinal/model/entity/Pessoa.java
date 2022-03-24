package edu.mjv.school.projetofinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@MappedSuperclass
public abstract class Pessoa extends DataBaseEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private  String nome;

    @Column(length = 11, nullable = false)
    @Pattern(regexp = "[0-9]{11}", message = "CPF deve conter apenas numeros")
    private  String cpf;

    @Column(nullable = false)
    private  String rg;

    @Column(length = 12)
    private  String telefone;

    @Email
    private  String email;

    @Temporal(TemporalType.DATE)
    private Calendar dataNaciento;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Endereco> enderecos;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNaciento() {
        return dataNaciento;
    }

    public void setDataNaciento(Calendar dataNaciento) {
        this.dataNaciento = dataNaciento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
