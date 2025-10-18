package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Jogo extends Conteudo {
    @OneToMany(mappedBy = "jogobase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dlc> dlcs = new ArrayList<>();


    public Jogo(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto) {
        super(nome, desenvolvedora, descricao,
                valor, pCusto);
    }
}
