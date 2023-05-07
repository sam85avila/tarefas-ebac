package com.samuel.tarefa13;

public class PessoaFisica extends Pessoa{

    private String cpf;

    @Override
    public void imprimirCadastro() {
        System.out.println("Nome: " + this.getNome() + " "
                            + this.getSobrenome()
                            + "\nCPF: " + this.cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
