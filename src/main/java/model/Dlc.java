package model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dlc extends Conteudo {
    @ManyToOne(optional = true)
    @JoinColumn(name = "jogo_id")
    private Jogo jogobase;

    public Dlc(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto, Jogo jogobase) {
        super(nome, desenvolvedora, descricao,
                valor, pCusto);
        setJogoBase(jogobase);
    }

    public void setJogoBase(Jogo jogobase) {
        this.jogobase = jogobase;
    }

    public Jogo getJogobase() {
        return this.jogobase;
    }

}
