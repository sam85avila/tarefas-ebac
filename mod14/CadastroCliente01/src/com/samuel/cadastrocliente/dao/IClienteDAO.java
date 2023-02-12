package com.samuel.cadastrocliente.dao;

import com.samuel.cadastrocliente.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    Boolean cadastrar(Cliente cliente);
    void excluir(Long cpf);
    void alterar(Long cpf, Cliente cliente);
    Cliente consultar(Long cpf);
    Collection<Cliente> buscarTodos();
}
