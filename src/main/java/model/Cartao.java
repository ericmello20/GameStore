package model;

public class Cartao {
    private int id;
    private String bandeira;
    private String numero;
    private String cvv;
    // private String validade; // ainda nao sei mexer com datas, por isso esta
    // comentada essa linha
    private String cpfTitular;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBandeira() {
        return this.bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /*
     * public String getValidade() {
     * return this.validade;
     * }
     * public void setValidade(String validade) {
     * this.validade = validade;
     * }
     */
    
    public String getCpfTitular() {
        return this.cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

}
