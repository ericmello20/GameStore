package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends Entidade {
    @jakarta.persistence.Column(nullable = false)
    private String nome;

    private String email;
    private String senha;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conteudo> conteudosCriados = new ArrayList<>();

    @OneToMany(mappedBy = "alteradoPor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conteudo> conteudosAlterados = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cartao> cartoes;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Biblioteca biblioteca;

    public Usuario() {
        cartoes = new ArrayList<Cartao>();
        configurarBiblioteca();
    }

    public Usuario(String nome, String email, String senha, LocalDate dataNascimento) {
        this();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        configurarBiblioteca();
    }

    private void configurarBiblioteca() {
        if (this.biblioteca != null) {
            this.biblioteca.setCliente(this);
        }
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

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Conteudo> getConteudosCriados() {
        return this.conteudosCriados;
    }

    public void setConteudosCriados(List<Conteudo> conteudosCriados) {
        this.conteudosCriados = conteudosCriados;
    }

    public List<Conteudo> getConteudosAlterados() {
        return this.conteudosAlterados;
    }

    public void setConteudosAlterados(List<Conteudo> conteudosAlterados) {
        this.conteudosAlterados = conteudosAlterados;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
