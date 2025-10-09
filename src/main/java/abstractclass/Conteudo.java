package abstractclass;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Conteudo {
    private int id;
    private String nome;
    private String desenvolvedora;
    private String descricao;
    private double valor;
    private double pCusto;
    // private String dataCadastro;
    // private String dataLancamento;

    public Conteudo(String nome, String desenvolvedora, String descricao,
            double valor, double pCusto) {
        setNome(nome);
        setDesenvolvedora(desenvolvedora);
        setDescricao(descricao);
        setValor(valor);
        setPCusto(pCusto);

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return this.desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPCusto() {
        return this.pCusto;
    }

    public void setPCusto(double pCusto) {
        this.pCusto = pCusto;
    }
    
    /*
    public String getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(String dataLancamento2) {
        this.dataLancamento = dataLancamento2;
    }
    */

}
