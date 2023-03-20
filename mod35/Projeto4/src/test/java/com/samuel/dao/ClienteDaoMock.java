package com.samuel.dao;

import java.util.Collection;

import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IGenericJpaDao<Cliente, Long> {


	@Override
	public Cliente cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		return entity;
	}

	@Override
	public void excluir(Cliente entity) throws DAOException {

	}

	@Override
	public Cliente alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
		return entity;
	}

	@Override
	public Cliente consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(id);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() throws DAOException {
		return null;
	}
}
