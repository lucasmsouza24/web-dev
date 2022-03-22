package com.sptech.demo.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salgadinho {
    @Id // pacote do javax.persistene
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private Integer nivelSal;
    private Double preco;
    private Boolean apimentado;

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getNivelSal() {
        return nivelSal;
    }
    public void setNivelSal(Integer nivelSal) {
        this.nivelSal = nivelSal;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Boolean getApimentado() {
        return apimentado;
    }
    public void setApimentado(Boolean apimentado) {
        this.apimentado = apimentado;
    }
}
