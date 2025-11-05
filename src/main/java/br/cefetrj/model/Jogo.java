package br.cefetrj.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Jogo extends Conteudo {

    @ManyToMany(mappedBy = "jogos")
    
    private List<Biblioteca> biblioteca = new ArrayList<>();
    @OneToMany(mappedBy = "jogoBase", cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Dlc> dlcs = new ArrayList<>();

    public Jogo() {
        super(null, null, null, 0.0, 0.0, null);
    }

    public Jogo(String nome, String desenvolvedora, String descricao,
            double valor, Double pCusto, LocalDate dataLancamento) {
        super(nome, desenvolvedora, descricao, valor, pCusto, dataLancamento);
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
