package br.cefetrj.to.input;

import java.time.LocalDate;

import br.cefetrj.model.Cartao;

public class CartaoTOInput {
    private Integer id;
    private String bandeira;
    private String numero;
    private String cvv;
    private LocalDate validade;
    private String cpfTitular;
    private UsuarioTOInput usuario;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioTOInput getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTOInput usuario) {
        this.usuario = usuario;
    }

    public Cartao build() {
        var cartao = new Cartao();
        cartao.setId(id);
        cartao.setBandeira(bandeira);
        cartao.setNumero(numero);
        cartao.setCvv(cvv);
        cartao.setValidade(validade);
        cartao.setCpfTitular(cpfTitular);
        if (usuario != null) {
            cartao.setUsuario(usuario.build());
        }
        return cartao;
    }
}
