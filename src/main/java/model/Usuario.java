package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("Cliente")
public class Usuario extends Entidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    @Transient
    private List<Cartao> cartoes;
    // private LocalDate dataCadastro;
    @Transient
    private Biblioteca biblioteca;
    // private LocalDate dataNascimento;

    public Usuario(String nome, String email, String senha) {
        cartoes = new ArrayList<Cartao>();
        biblioteca = new Biblioteca();
        setNome(nome);
        setEmail(email);
        setSenha(senha);

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cartao> getCartoes() {
        return this.cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
    /*
     * public LocalDate getDataCadastro() {
     * return this.dataCadastro;
     * }
     * 
     * public void setDataCadastro(LocalDate dataCadastro) {
     * this.dataCadastro = dataCadastro;
     * }
     * public String getDataNascimento() {
     * return this.dataNascimento;
     * }
     * 
     * public void setDataNascimento(String dataNascimento) {
     * this.dataNascimento = dataNascimento;
     * }
     */

    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}
