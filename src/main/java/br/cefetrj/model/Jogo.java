package br.cefetrj.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Jogo extends Conteudo {

    @ManyToMany(mappedBy = "jogos")
    private List<Biblioteca> biblioteca = new ArrayList<>();
    @OneToMany(mappedBy = "jogoBase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dlc> dlcs = new ArrayList<>();

    public Jogo() {
        super(null, null, null, 0, 0);
    }

    public Jogo(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto) {
        super(nome, desenvolvedora, descricao, valor, pCusto);
    }

    public List<Dlc> getDlcs() {
        return dlcs;
    }

    public void setDlcs(List<Dlc> dlcs) {
        this.dlcs = dlcs;
    }

    public List<Biblioteca> getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(List<Biblioteca> biblioteca) {
        this.biblioteca = biblioteca;
    }
}
