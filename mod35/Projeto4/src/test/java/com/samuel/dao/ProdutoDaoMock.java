package com.samuel.dao;

import java.util.Collection;

import com.samuel.domain.Produto;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;


public class ProdutoDaoMock implements IProdutoDAO {


	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
		return null;
	}

	@Override
	public void excluir(String valor) throws DAOException {

	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {

	}

	@Override
	public Produto consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() throws DAOException {
		return null;
	}
}
