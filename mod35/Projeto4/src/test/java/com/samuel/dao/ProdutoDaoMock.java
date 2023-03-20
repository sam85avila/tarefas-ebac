/**
 * 
 */
package com.samuel.dao;

import java.util.Collection;

import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.domain.Produto;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDaoMock implements IGenericJpaDao<Produto, String> {


	@Override
	public Produto cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
		return entity;
	}

	@Override
	public void excluir(Produto entity) throws DAOException {

	}

	@Override
	public Produto alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
		return entity;
	}

	@Override
	public Produto consultar(String id) throws MaisDeUmRegistroException, TableException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(id);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() throws DAOException {
		return null;
	}
}
