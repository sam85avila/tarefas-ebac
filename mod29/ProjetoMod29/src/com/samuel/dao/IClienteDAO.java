package com.samuel.dao;

import com.samuel.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    Cliente buscarUm(String codigo) throws Exception;

    Integer excluir(Cliente clienteBD) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Integer atualizar(Cliente clienteBD) throws Exception;
}
