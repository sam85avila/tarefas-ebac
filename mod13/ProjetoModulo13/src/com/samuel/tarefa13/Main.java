package com.samuel.tarefa13;

public class Main {

    public static void main(String[] args) {

//        CPF e CNPJ gerados no 4devs.com.br
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Jó");
        pf.setSobrenome("Pereira");
        pf.setCpf("480.106.240-71");

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Maya");
        pj.setSobrenome("Perez");
        pj.setCnpj("22.789.860/0001-99");

        System.out.println("\n*** Pessoa Física ***");
        pf.imprimirCadastro();

        System.out.println("\n*** Pessoa Jurídica ***");
        pj.imprimirCadastro();

    }
}
