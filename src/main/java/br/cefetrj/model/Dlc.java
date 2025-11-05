package br.cefetrj.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Dlc extends Conteudo {

    @ManyToOne(optional = false)
    @JoinColumn(name = "jogo_id", nullable = false)

    private Jogo jogoBase;

    public Dlc() {
        super(null, null, null, 0.0, 0.0, null);
    }

    public Dlc(String nome, String desenvolvedora, String descricao,
            Double valor, Double pCusto, Jogo jogoBase, LocalDate dataLancamento) {
        super(nome, desenvolvedora, descricao, valor, pCusto, dataLancamento);
        setJogoBase(jogoBase);
    }

    public Jogo getJogoBase() {
        return this.jogoBase;
    }

    public void setJogoBase(Jogo jogoBase) {
        this.jogoBase = jogoBase;
    }
}
