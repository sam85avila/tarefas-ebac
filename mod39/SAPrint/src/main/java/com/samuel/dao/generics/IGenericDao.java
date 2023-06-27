package com.samuel.dao.generics;

import java.io.Serializable;
import java.util.Collection;

import com.samuel.exception.DaoException;
import com.samuel.exception.MaisDeUmRegistroException;
import com.samuel.exception.TableException;
import com.samuel.model.Persistente;

public interface IGenericDao <T extends Persistente, E extends Serializable>{
    
    T cadastrar(T entity) throws DaoException;
    void excluir(T entity) throws DaoException;
    T alterar(T entity) throws DaoException;
    T consultar(E cpf) throws DaoException, MaisDeUmRegistroException, TableException ;
    Collection<T> buscarTodos() throws DaoException;
    
}
