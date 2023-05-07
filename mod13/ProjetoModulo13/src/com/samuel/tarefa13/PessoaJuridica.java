package com.samuel.tarefa13;

public class PessoaJuridica extends Pessoa{

    private String cnpj;

    @Override
    public void imprimirCadastro() {
        System.out.println("Nome: " + this.getNome() + " "
                + this.getSobrenome()
                + "\nCNPJ: " + this.cnpj);
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
