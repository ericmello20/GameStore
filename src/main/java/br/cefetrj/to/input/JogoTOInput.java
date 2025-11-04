package br.cefetrj.to.input;

import java.io.Serializable;
import java.time.LocalDate;

import br.cefetrj.model.Jogo;

public class JogoTOInput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private Double valor;
    private Double pCusto;
    private LocalDate dataLancamento;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getpCusto() {
        return pCusto;
    }

    public void setpCusto(Double pCusto) {
        this.pCusto = pCusto;
    }

    public Jogo build() {
        var jogo = new Jogo(nome, desenvolvedora, descricao, valor, pCusto, dataLancamento);
        jogo.setId(id);
        return jogo;
    }
}
