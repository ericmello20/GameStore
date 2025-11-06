package br.cefetrj.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Biblioteca extends Entidade {
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name = "biblioteca_jogo", joinColumns = @JoinColumn(name = "biblioteca_id"), inverseJoinColumns = @JoinColumn(name = "jogo_id"))
   
    private List<Jogo> jogos = new ArrayList<>();

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(List<Jogo> jogo) {
        this.jogos = jogo;
    }

}
