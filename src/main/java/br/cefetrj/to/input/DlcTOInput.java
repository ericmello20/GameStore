package br.cefetrj.to.input;

import java.io.Serializable;

import br.cefetrj.model.Dlc;
import br.cefetrj.model.Jogo;

public class DlcTOInput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;
    private Integer jogoBaseId; // apenas o ID do jogo base

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getpCusto() {
        return pCusto;
    }

    public void setpCusto(double pCusto) {
        this.pCusto = pCusto;
    }

    public Integer getJogoBaseId() {
        return jogoBaseId;
    }

    public void setJogoBaseId(Integer jogoBaseId) {
        this.jogoBaseId = jogoBaseId;
    }

    public Dlc build(Jogo jogoBase) {
        var dlc = new Dlc(nome, desenvolvedora, descricao, valor, pCusto, jogoBase);
        dlc.setId(id);
        return dlc;
    }
}
