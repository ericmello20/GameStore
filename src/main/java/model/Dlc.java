package model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dlc extends Conteudo {

    @ManyToOne(optional = true)
    @JoinColumn(name = "jogo_id")
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



