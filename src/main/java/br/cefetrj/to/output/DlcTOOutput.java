package br.cefetrj.to.output;

import java.io.Serializable;

import br.cefetrj.model.Dlc;

public class DlcTOOutput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;
    private JogoTOOutput jogoBase;

    public DlcTOOutput(Dlc dlc) {
        this.id = dlc.getId();
        this.nome = dlc.getNome();
        this.desenvolvedora = dlc.getDesenvolvedora();
        this.descricao = dlc.getDescricao();
        this.valor = dlc.getValor();
        this.pCusto = dlc.getPCusto();

        if (dlc.getJogoBase() != null) {
            this.jogoBase = new JogoTOOutput(dlc.getJogoBase(), false);
        }
    }

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

    public JogoTOOutput getJogoBase() {
        return jogoBase;
    }

    public void setJogoBase(JogoTOOutput jogoBase) {
        this.jogoBase = jogoBase;
    }
}
