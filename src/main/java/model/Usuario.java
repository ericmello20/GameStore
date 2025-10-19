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

    @jakarta.persistence.Column(nullable = false, unique = true)
    private String email;

    @jakarta.persistence.Column(nullable = false)
    private String senha;

    @jakarta.persistence.Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "criadoPor")
    private List<Conteudo> conteudosCriados = new ArrayList<>();

    @OneToMany(mappedBy = "alteradoPor")
    private List<Conteudo> conteudosAlterados = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cartao> cartoes;

    // UM PARA UM COM BIBLIOTECA POIS OS USUARIOS TERAO APENAS UMA BIBLIOTECA
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Biblioteca biblioteca;

    // Construtor padrão necessário para o JPA
    public Usuario() {
        cartoes = new ArrayList<Cartao>();
        biblioteca = new Biblioteca();
        configurarBiblioteca();
    }

    // CONSTRUTOR
    public Usuario(String nome, String email, String senha, LocalDate dataNascimento) {
        this(); // chama o construtor padrão
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setDataNascimento(dataNascimento);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para configurar corretamente o relacionamento bidirecional
    private void configurarBiblioteca() {
        if (this.biblioteca != null) {
            this.biblioteca.setCliente(this);
        }
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

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
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

}
