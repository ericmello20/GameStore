package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("Cliente")
public class Usuario extends Entidade {
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    @OneToMany(mappedBy = "criadoPor")
    private List<Conteudo> conteudosCriados = new ArrayList<>();

    @OneToMany(mappedBy = "alteradoPor")
    private List<Conteudo> conteudosAlterados = new ArrayList<>();


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cartao> cartoes;

    // UM PARA UM COM BIBLIOTECA POIS OS USUARIOS TERAO APENAS UMA BIBLIOTECA
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Biblioteca biblioteca;

    // CONSTRUTOR
    public Usuario(String nome, String email, String senha) {
        cartoes = new ArrayList<Cartao>();
        biblioteca = new Biblioteca();
        setNome(nome);
        setEmail(email);
        setSenha(senha);
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

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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

}
