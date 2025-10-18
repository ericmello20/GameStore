package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Biblioteca extends Entidade{
    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private Usuario cliente;
    @ManyToMany(mappedBy = "biblioteca")
    @JoinColumn(name = "conteudo_id")
    private List<Conteudo> conteudos = new ArrayList<Conteudo>();
}
