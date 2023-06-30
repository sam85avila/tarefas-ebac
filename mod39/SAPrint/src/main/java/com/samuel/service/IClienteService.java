package com.samuel.service;

import java.util.List;

import com.samuel.exception.DaoException;
import com.samuel.model.Cliente;
import com.samuel.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
	
	Cliente buscarPorCpf(Long cpf) throws DaoException;
	List<Cliente> filtrarClientes(String query);
	
}
