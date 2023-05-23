package com.samuel.dao.generics;

import java.io.Serializable;
import java.util.Collection;

import com.samuel.exceptions.DaoExceptions;
import com.samuel.model.Persistente;

public interface IGenericDao <T extends Persistente, E extends Serializable>{
    
    T cadastrar(T entity) throws DaoExceptions;
    void excluir(T entity) throws DaoExceptions;
    T alterar(T entity) throws DaoExceptions;
    T consultar(E id) throws DaoExceptions;
    Collection<T> buscarTodos() throws DaoExceptions;
    
}
