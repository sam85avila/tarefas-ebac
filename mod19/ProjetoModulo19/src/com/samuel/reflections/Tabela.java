package com.samuel.reflections;

@TabelaAnnotation(value = "tabela")
public class Tabela {

    @TabelaAnnotation(value = "nome")
    private String nome;

    public Tabela() {
    }

    public Tabela(String nome) {
        this.nome = nome;
    }

}
