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
    private LocalDate dataLancamento;
    private Integer idJogoBase; // Evita dependência recursiva com JogoTOOutput

    public DlcTOOutput(Dlc dlc) {
        this(dlc, false);
    }

    public DlcTOOutput(Dlc dlc, boolean incluirJogoBase) {
        if (dlc == null)
            return;

        this.id = dlc.getId();
        this.nome = dlc.getNome();
        this.desenvolvedora = dlc.getDesenvolvedora();
        this.descricao = dlc.getDescricao();
        this.valor = dlc.getValor();
        this.pCusto = dlc.getpCusto();
        this.dataLancamento = dlc.getDataLancamento();

        if (incluirJogoBase && dlc.getJogoBase() != null) {
            this.idJogoBase = dlc.getJogoBase().getId();
        }
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Double getpCusto() {
        return pCusto;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Integer getIdJogoBase() {
        return idJogoBase;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setpCusto(Double pCusto) {
        this.pCusto = pCusto;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setIdJogoBase(Integer idJogoBase) {
        this.idJogoBase = idJogoBase;
    }
}
