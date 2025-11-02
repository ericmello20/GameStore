package br.cefetrj.to.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Biblioteca;

public class BibliotecaTOOutput implements Serializable {

    private UsuarioTOOutput usuario;
    private List<JogoTOOutput> jogos = new ArrayList<>();

    public BibliotecaTOOutput() { }

    public BibliotecaTOOutput(Biblioteca biblioteca) {
        if (biblioteca.getUsuario() != null) {
            this.usuario = new UsuarioTOOutput(biblioteca.getUsuario());
        }

        if (biblioteca.getJogos() != null) {
            this.jogos = biblioteca.getJogos().stream()
                    .map(JogoTOOutput::new) // Construtor de JogoTOOutput que recebe entidade Jogo
                    .toList();
        }
    }

    // Getters e setters
    public UsuarioTOOutput getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTOOutput usuario) {
        this.usuario = usuario;
    }

    public List<JogoTOOutput> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoTOOutput> jogos) {
        this.jogos = jogos;
    }
}
