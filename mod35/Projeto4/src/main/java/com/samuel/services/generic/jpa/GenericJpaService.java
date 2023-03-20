package com.samuel.services.generic.jpa;

import com.samuel.dao.Persistente;
import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable> implements IGenericJpaService<T, E>{
    protected IGenericJpaDao<T, E> genericJpaDao;

    public GenericJpaService(IGenericJpaDao<T, E> genericJpaDao) {
        this.genericJpaDao = genericJpaDao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.genericJpaDao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.genericJpaDao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.genericJpaDao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException {
        return this.genericJpaDao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.genericJpaDao.buscarTodos();
    }
}
