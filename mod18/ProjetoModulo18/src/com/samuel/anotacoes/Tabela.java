package com.samuel.anotacoes;

@TabelaAnnotation(value = "tabela")
public class Tabela {

    @TabelaAnnotation(value = "nome")
    private String nome;

    public Tabela(String nome) {
        this.nome = nome;
    }

}
