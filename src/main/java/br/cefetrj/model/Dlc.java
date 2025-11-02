package br.cefetrj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dlc extends Conteudo {

    @ManyToOne(optional = false)
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogoBase;

    public Dlc() {
        super(null, null, null, 0, 0);
    }

    public Dlc(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto, Jogo jogoBase) {
        super(nome, desenvolvedora, descricao, valor, pCusto);
        setJogoBase(jogoBase);
    }

    public Jogo getJogoBase() {
        return this.jogoBase;
    }

    public void setJogoBase(Jogo jogoBase) {
        this.jogoBase = jogoBase;
    }
}
