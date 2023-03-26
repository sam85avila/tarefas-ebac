package com.samuel.services.generic.jpa;

import com.samuel.domain.jpa.Persistente;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericJpaService<T extends Persistente, E extends Serializable> {
    T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    void excluir(T entity) throws DAOException;
    T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException;
    Collection<T> buscarTodos() throws DAOException;
}
