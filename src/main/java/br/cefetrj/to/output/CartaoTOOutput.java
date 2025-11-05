package br.cefetrj.to.output;

import java.io.Serializable;
import java.time.LocalDate;

import br.cefetrj.model.Cartao;

public class CartaoTOOutput implements Serializable {
    private Integer id;
    private String bandeira;
    private String numero;
    private String cvv;
    private LocalDate validade;
    private String cpfTitular;
    private Integer idUsuario; // <- evita recursão

    public CartaoTOOutput(Cartao cartao) {
        this.id = cartao.getId();
        this.bandeira = cartao.getBandeira();
        this.numero = cartao.getNumero();
        this.cvv = cartao.getCvv();
        this.validade = cartao.getValidade();
        this.cpfTitular = cartao.getCpfTitular();
        if (cartao.getUsuario() != null) {
            this.idUsuario = cartao.getUsuario().getId();
        }
    }

    public CartaoTOOutput(Cartao cartao, boolean incluirUsuario) {
        this.id = cartao.getId();
        this.bandeira = cartao.getBandeira();
        this.numero = cartao.getNumero();
        this.cvv = cartao.getCvv();
        this.validade = cartao.getValidade();
        this.cpfTitular = cartao.getCpfTitular();
        if (incluirUsuario && cartao.getUsuario() != null) {
            this.idUsuario = cartao.getUsuario().getId();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    /*
     * public UsuarioTOOutput getUsuario() {
     * return usuario;
     * }
     * 
     * public void setUsuario(UsuarioTOOutput usuario) {
     * this.usuario = usuario;
     * }
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
