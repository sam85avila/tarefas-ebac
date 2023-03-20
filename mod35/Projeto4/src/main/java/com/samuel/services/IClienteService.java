/**
 * 
 */
package com.samuel.services;

import com.samuel.domain.Cliente;
import com.samuel.exceptions.DAOException;
import com.samuel.services.generic.jpa.IGenericJpaService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericJpaService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
