/**
 * 
 */
package com.samuel.services;

import com.samuel.dao.IClienteJpaDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.services.generic.jpa.GenericJpaService;

public class ClienteService extends GenericJpaService<Cliente, Long> implements IClienteService {
	
	private IClienteJpaDao clienteDAO;
	
	public ClienteService(IClienteJpaDao clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return clienteDAO.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
