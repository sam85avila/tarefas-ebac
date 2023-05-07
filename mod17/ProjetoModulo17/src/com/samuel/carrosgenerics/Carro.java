package com.samuel.carrosgenerics;

public abstract class Carro {

    private String nome;
    private Long id;

    public Carro(Long id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public void info() {
        System.out.println("Id: " + id + " - Carro: " + nome + " - Marca: "
                + this.getClass().getSimpleName());
    }

}
