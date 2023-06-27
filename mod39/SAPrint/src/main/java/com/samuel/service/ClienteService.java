package com.samuel.service;

import java.util.List;

import javax.inject.Inject;
import javax.ejb.Stateless;

import com.samuel.dao.IClienteDao;
import com.samuel.exception.DaoException;
import com.samuel.exception.MaisDeUmRegistroException;
import com.samuel.exception.TableException;
import com.samuel.model.Cliente;
import com.samuel.service.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Integer> implements IClienteService{

	private IClienteDao clienteDao;
	
	@Inject
	public ClienteService(IClienteDao clienteDao) {
		super(clienteDao);
		this.clienteDao = clienteDao;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDao.filtrarClientes(query);
	}

	@Override
	public Cliente buscarPorCpf(Integer cpf) throws DaoException {
		try {
			clienteDao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
