package com.samuel.cadastrocliente;

import com.samuel.cadastrocliente.dao.ClienteMapDAO;
import com.samuel.cadastrocliente.dao.IClienteDAO;
import com.samuel.cadastrocliente.domain.Cliente;

import javax.swing.*;
import java.util.Collection;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String[] opcoes = {"Cadastrar", "Consultar", "Alterar", "Excluir", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Clique para escolher",
                "Sistema Cadastro de cliente", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcoes, 0);
        do {
            switch (opcao) {
                case 0:
                    Cliente cliente = cadastrarCliente();
                    iClienteDAO.cadastrar(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    break;

                case 1:
                    String[] consultas = {"Buscar um cliente", "Buscar todos os clientes"};

                    int tipoConsulta = JOptionPane.showOptionDialog(null, "Esolha o tipo de consulta",
                            "Consultar Cliente", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, consultas, 0);

                    if (tipoConsulta == 0) {
                        String cpfStr = JOptionPane.showInputDialog(null,
                                "Digite o cpf",
                                "Consultar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        Long cpfCliente = Long.parseLong(cpfStr);
                        Cliente clienteEncontrado = iClienteDAO.consultar(cpfCliente);
                        JOptionPane.showMessageDialog(null, clienteEncontrado.toString());
                    } else {
                        Collection<Cliente> clienteCollection = iClienteDAO.buscarTodos();
                        JOptionPane.showMessageDialog(null, clienteCollection);
                    }
                    break;

                case 2:
                    Cliente clienteAtualizar = encontrarCliente();
                    if (clienteAtualizar != null) {
                        iClienteDAO.cadastrar(cadastrarCliente());
                        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                        break;
                    }
//
                case 3:
                    Cliente clienteExcluir = encontrarCliente();
                    if (clienteExcluir != null) {
                        iClienteDAO.excluir(clienteExcluir.getCpf());
                        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                        break;
                    }

                case 4:
                    System.exit(0);
                    break;
            }
            opcao = JOptionPane.showOptionDialog(null, "Clique para escolher",
                    "Sistema Cadastro de cliente", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, 0);
        } while (opcao != 4);

    }

    private static Cliente encontrarCliente() {
        String cpfStr = JOptionPane.showInputDialog(null,
                "Digite o CPF do cliente.",
                "Alteração de Cliente", JOptionPane.INFORMATION_MESSAGE);
        Cliente clienteEncontrado = iClienteDAO.consultar(Long.parseLong(cpfStr));
        return clienteEncontrado;
    }

    private static Cliente cadastrarCliente() {
        String nome = JOptionPane.showInputDialog(null,
                "Digite o nome.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String cpf = JOptionPane.showInputDialog(null,
                "Digite o CPF.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String telefone = JOptionPane.showInputDialog(null,
                "Digite o Telefone.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String endereco = JOptionPane.showInputDialog(null,
                "Digite o Endereço.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String numero = JOptionPane.showInputDialog(null,
                "Digite o Número.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String cidade = JOptionPane.showInputDialog(null,
                "Digite o Cidade.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        String estado = JOptionPane.showInputDialog(null,
                "Digite o Estado.",
                "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        return new Cliente(nome, cpf, telefone, endereco, numero, cidade, estado);
    }
}
