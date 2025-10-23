package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conteudo extends Entidade {
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;

    @ManyToMany
    @JoinTable(name = "Biblioteca_Conteudo", joinColumns = @JoinColumn(name = "conteudo_id"), inverseJoinColumns = @JoinColumn(name = "biblioteca_id"))
    private List<Biblioteca> biblioteca = new ArrayList<>();

    private LocalDate dataLancamento;

    // 🔹 ADICIONE ESTE BLOCO
    @ManyToOne
    @JoinColumn(name = "id_criador")
    private Usuario criador;

    public Conteudo() {
    }

    public Conteudo(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto) {
        setNome(nome);
        setDesenvolvedora(desenvolvedora);
        setDescricao(descricao);
        setValor(valor);
        setPCusto(pCusto);
    }

    // 🔹 Getters e Setters
    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<Biblioteca> getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(List<Biblioteca> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return this.desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPCusto() {
        return this.pCusto;
    }

    public void setPCusto(double pCusto) {
        this.pCusto = pCusto;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento2) {
        this.dataLancamento = dataLancamento2;
    }
}
