package com.samuel.dao;

import java.util.Collection;

import com.samuel.domain.Cliente;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO {


	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		return true;
	}

	@Override
	public void excluir(Long valor) throws DAOException {

	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {

	}

	@Override
	public Cliente consultar(Long valor) throws MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() throws DAOException {
		return null;
	}
}
