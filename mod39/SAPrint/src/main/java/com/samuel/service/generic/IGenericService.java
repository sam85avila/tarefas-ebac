package com.samuel.service.generic;

import java.io.Serializable;
import java.util.Collection;

import com.samuel.exception.DaoException;
import com.samuel.exception.MaisDeUmRegistroException;
import com.samuel.exception.TableException;
import com.samuel.model.Persistente;

public interface IGenericService<T extends Persistente, E extends Serializable> {
	
	T cadastrar(T entity) throws DaoException;
	void excluir(T entity) throws DaoException;
	T alterar(T entity) throws DaoException;
	T consultar(E value) throws DaoException, MaisDeUmRegistroException, TableException;
	Collection<T> buscarTodos() throws DaoException;
}
