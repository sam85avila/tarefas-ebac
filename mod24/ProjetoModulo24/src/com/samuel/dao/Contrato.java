package com.samuel.dao;

public class Contrato {

    private Long id;
    private String descricao;

    public Contrato() {
    }

    public Contrato(Long id, String nome) {
        this.id = id;
        this.descricao = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return descricao;
    }

    public void setNome(String nome) {
        this.descricao = nome;
    }
}
