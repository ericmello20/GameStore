package br.cefetrj.to.output;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.cefetrj.model.Usuario;

public class UsuarioTOOutput implements Serializable {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private List<CartaoTOOutput> cartoes;
    private Integer idBiblioteca;

    public UsuarioTOOutput(Usuario u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.dataNascimento = u.getDataNascimento();

        if (u.getCartoes() != null) {
            this.cartoes = u.getCartoes().stream()
                    .map(c -> new CartaoTOOutput(c, false))
                    .toList();
        }

        if (u.getBiblioteca() != null) {
            this.idBiblioteca = u.getBiblioteca().getId();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CartaoTOOutput> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoTOOutput> cartoes) {
        this.cartoes = cartoes;
    }

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

}
