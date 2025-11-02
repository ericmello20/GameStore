package br.cefetrj.to.output;

import java.io.Serializable;
import java.util.List;

import br.cefetrj.model.Jogo;

public class JogoTOOutput implements Serializable {

    private Integer id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;
    private List<DlcTOOutput> dlcs;

    public JogoTOOutput(Jogo jogo) {
        this(jogo, true);
    }

    public JogoTOOutput(Jogo jogo, boolean incluirDlcs) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.desenvolvedora = jogo.getDesenvolvedora();
        this.descricao = jogo.getDescricao();
        this.valor = jogo.getValor();
        this.pCusto = jogo.getPCusto();

        if (incluirDlcs && jogo.getDlcs() != null) {
            this.dlcs = jogo.getDlcs()
                    .stream()
                    .map(d -> new DlcTOOutput(d))
                    .toList();
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

    public List<DlcTOOutput> getDlcs() {
        return dlcs;
    }

    public void setDlcs(List<DlcTOOutput> dlcs) {
        this.dlcs = dlcs;
    }
}
