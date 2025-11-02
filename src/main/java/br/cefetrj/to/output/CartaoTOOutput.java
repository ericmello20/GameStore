package br.cefetrj.to.output;

import java.time.LocalDate;

import br.cefetrj.model.Cartao;

public class CartaoTOOutput {
    private Integer id;
    private String bandeira;
    private String numero;
    private String cvv;
    private LocalDate validade;
    private String cpfTitular;
    private UsuarioTOOutput usuario;

    public CartaoTOOutput(Cartao cartao) {
        this.id = cartao.getId();
        this.bandeira = cartao.getBandeira();
        this.numero = cartao.getNumero();
        this.cvv = cartao.getCvv();
        if (cartao.getUsuario() != null) {
            this.usuario = new UsuarioTOOutput(cartao.getUsuario());
        }
    }

    public CartaoTOOutput(Cartao cartao, boolean carregarUsuario) {
        UsuarioTOOutput usuarioTO = null;
        if (carregarUsuario && cartao.getUsuario() != null) {
            usuarioTO = new UsuarioTOOutput(cartao.getUsuario());
        }
        this.id = cartao.getId();
        this.bandeira = cartao.getBandeira();
        this.numero = cartao.getNumero();
        this.cvv = cartao.getCvv();
        this.validade = cartao.getValidade();
        this.cpfTitular = cartao.getCpfTitular();
        this.usuario = usuarioTO;
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

    public UsuarioTOOutput getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTOOutput usuario) {
        this.usuario = usuario;
    }

}
