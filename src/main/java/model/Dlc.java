package model;

import abstractclass.Conteudo;

public class Dlc extends Conteudo {
    private Jogo jogobase;

    public Dlc(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto, Jogo jogobase) {
        super(nome, desenvolvedora, descricao,
                valor, pCusto);
        setJogoBase(jogobase);
    }

    private void setJogoBase(Jogo jogobase) {
        this.jogobase = jogobase;
    }

    public Jogo getJogobase() {
        return this.jogobase;
    }

}
