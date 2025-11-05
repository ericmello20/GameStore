package br.cefetrj.to.output;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import br.cefetrj.model.Jogo;

public class JogoTOOutput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;
    private LocalDate dataLancamento;
    private List<DlcTOOutput> dlcs;

    public JogoTOOutput(Jogo jogo) {
        this(jogo, true);
    }

    public JogoTOOutput(Jogo jogo, boolean incluirDlcs) {
        if (jogo == null)
            return;

        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.desenvolvedora = jogo.getDesenvolvedora();
        this.descricao = jogo.getDescricao();
        this.valor = jogo.getValor();
        this.pCusto = jogo.getpCusto();
        this.dataLancamento = jogo.getDataLancamento();

        if (incluirDlcs && jogo.getDlcs() != null) {
            this.dlcs = jogo.getDlcs()
                    .stream()
                    .map(d -> new DlcTOOutput(d, false)) // impede loop Jogo ↔ DLC
                    .toList();
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

    public double getValor() {
        return valor;
    }

    public double getpCusto() {
        return pCusto;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public List<DlcTOOutput> getDlcs() {
        return dlcs;
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setpCusto(double pCusto) {
        this.pCusto = pCusto;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDlcs(List<DlcTOOutput> dlcs) {
        this.dlcs = dlcs;
    }
}
