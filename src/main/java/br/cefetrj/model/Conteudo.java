package br.cefetrj.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conteudo extends Entidade {

    @Column(nullable = false)
    private String nome;

    private String desenvolvedora;

    private String descricao;

    @Column(nullable = false)
    private Double valor = 0.0;

    @Column(name = "p_custo", nullable = false)
    private Double pCusto = 0.0;

    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "id_criador")
    private Usuario criador;

    public Conteudo() {
        this.valor = 0.0;
        this.pCusto = 0.0;
    }

    public Conteudo(String nome, String desenvolvedora, String descricao,
            Double valor, Double pCusto, LocalDate dataLancamento) {
        this.nome = nome;
        this.desenvolvedora = desenvolvedora;
        this.descricao = descricao;
        this.valor = (valor != null) ? valor : 0.0;
        this.pCusto = (pCusto != null) ? pCusto : 0.0;
        this.dataLancamento = dataLancamento;
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

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = (valor != null) ? valor : 0.0;
    }

    public Double getpCusto() {
        return this.pCusto;
    }

    public void setpCusto(Double pCusto) {
        this.pCusto = (pCusto != null) ? pCusto : 0.0;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
