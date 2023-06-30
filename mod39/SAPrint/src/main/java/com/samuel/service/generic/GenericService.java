package com.samuel.service.generic;

import java.io.Serializable;
import java.util.Collection;

import com.samuel.dao.generics.IGenericDao;
import com.samuel.exception.DaoException;
import com.samuel.exception.MaisDeUmRegistroException;
import com.samuel.exception.TableException;
import com.samuel.model.Persistente;

public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	
	protected IGenericDao<T, E> dao;

	public GenericService(IGenericDao<T, E> dao) {
		this.dao = dao;
	}
	
	@Override
	public T cadastrar(T entity) throws DaoException {
		return dao.cadastrar(entity);
	}
	
	@Override
	public T alterar(T entity) throws DaoException {
		return dao.alterar(entity);
	}
	
	@Override
	public T consultar(E value) throws DaoException, MaisDeUmRegistroException, TableException {
		return dao.consultar(value);
	}
	
	@Override
	public void excluir(T entity) throws DaoException {
		dao.excluir(entity);
	}
	
	@Override
	public Collection<T> buscarTodos() throws DaoException {
		return dao.buscarTodos();
	}

}
