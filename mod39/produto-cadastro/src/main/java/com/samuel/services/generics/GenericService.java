package com.samuel.services.generics;

import java.io.Serializable;
import java.util.Collection;

import com.samuel.dao.generic.IGenericDAO;
import com.samuel.exceptions.NegocioException;
import com.samuel.model.Persistente;

public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T, E> dao;
	
	public GenericService(IGenericDAO<T, E> dao) {
		this.dao = dao;
	}	

	@Override
	public T cadastrar(T entity)  throws NegocioException{
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity)  throws NegocioException{
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity)  throws NegocioException{
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor)  throws NegocioException{
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos()  throws NegocioException{
		return this.dao.buscarTodos();
	}

}
