package com.samuel.dao.generics;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samuel.exceptions.DaoExceptions;
import com.samuel.model.Persistente;

public class GenericDao <T extends Persistente, E extends Serializable> implements IGenericDao<T, E> {

    protected Class<T> persistenteClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDao (Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws DaoExceptions {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        return entity;
    }

    @Override
    public void excluir(T entity) throws DaoExceptions {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            T gerenciada = entityManager.find(this.persistenteClass, entity.getId());
            if (gerenciada != null) {
                entityManager.remove(gerenciada);
            }
        }
    }

    @Override
    public T alterar(T entity) throws DaoExceptions {
        return entityManager.merge(entity);
    }

    @Override
    public T consultar(E id) throws DaoExceptions {
        return entityManager.find(this.persistenteClass, id);    
    }

    @Override
    public Collection<T> buscarTodos() throws DaoExceptions {
       List<T> lista = entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
       return lista;
    }

    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(this.persistenteClass.getSimpleName());
		sb.append(" obj");
		return sb.toString();
    }
    
}
