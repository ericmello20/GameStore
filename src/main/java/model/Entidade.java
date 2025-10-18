package model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private LocalDate dataCriacao;
    private LocalDate dataUltimaAlteracao;
    @ManyToOne
    @JoinColumn(name = "criado_por_id")
    private Usuario criadoPor;

    @ManyToOne
    @JoinColumn(name = "alterado_por_id")
    private Usuario alteradoPor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataUltimaAlteracao() {
        return this.dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDate dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Usuario getCriadoPor() {
        return this.criadoPor;
    }

    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Usuario getAlteradoPor() {
        return this.alteradoPor;
    }

    public void setAlteradoPor(Usuario alteradoPor) {
        this.alteradoPor = alteradoPor;
    }
}