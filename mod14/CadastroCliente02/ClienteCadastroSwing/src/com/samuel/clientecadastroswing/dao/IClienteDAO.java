package com.samuel.clientecadastroswing.dao;

import com.samuel.clientecadastroswing.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    Boolean cadastrar(Cliente cliente);
    void excluir(Long cpf);
    Boolean alterar(Long cpf, Cliente cliente);
    Cliente consultar(Long cpf);
    Collection<Cliente> buscarTodos();
}
