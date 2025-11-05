package br.cefetrj.to.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import br.cefetrj.model.Biblioteca;

public class BibliotecaTOOutput implements Serializable {

    private Integer id;
    private Integer idUsuario; 
    private List<JogoTOOutput> jogos = new ArrayList<>();

    public BibliotecaTOOutput() {
    }

    public BibliotecaTOOutput(Biblioteca biblioteca) {
        this.id = biblioteca.getId();

    
        if (biblioteca.getUsuario() != null) {
            this.idUsuario = biblioteca.getUsuario().getId();
        }

        if (biblioteca.getJogos() != null) {
            this.jogos = biblioteca.getJogos().stream()
                    .map(jogo -> new JogoTOOutput(jogo, false))
                    .toList();
        }
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<JogoTOOutput> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoTOOutput> jogos) {
        this.jogos = jogos;
    }
}
