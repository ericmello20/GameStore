package br.cefetrj.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conteudo extends Entidade {
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;

    private LocalDate dataLancamento;

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

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
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
