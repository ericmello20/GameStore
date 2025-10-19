package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cartao extends Entidade {
    @ManyToOne(optional = true)
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    private String bandeira;
    private String numero;
    private String cvv;
    private LocalDate validade;
    private String cpfTitular;

    public Usuario getCliente() {
        return this.cliente;
    }

    public String getBandeira() {
        return this.bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getValidade() {
        return this.validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCpfTitular() {
        return this.cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

}
