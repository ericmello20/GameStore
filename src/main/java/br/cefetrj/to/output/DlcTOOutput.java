package br.cefetrj.to.output;

import java.io.Serializable;
import java.time.LocalDate;

import br.cefetrj.model.Dlc;

public class DlcTOOutput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private Double valor;
    private Double pCusto;
    private JogoTOOutput jogoBase;
    private LocalDate dataLancamento;

    public DlcTOOutput(Dlc dlc) {
        this.id = dlc.getId();
        this.nome = dlc.getNome();
        this.desenvolvedora = dlc.getDesenvolvedora();
        this.descricao = dlc.getDescricao();
        this.valor = dlc.getValor();
        this.pCusto = dlc.getpCusto();
        this.dataLancamento = dlc.getDataLancamento();
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

    public JogoTOOutput getJogoBase() {
        return jogoBase;
    }

    public void setJogoBase(JogoTOOutput jogoBase) {
        this.jogoBase = jogoBase;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
