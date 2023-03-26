package com.samuel.dao.generic.jpa;

import com.samuel.domain.jpa.Persistente;

import java.io.Serializable;

public abstract class GenericJpaDB1DAO<T extends Persistente, E extends Serializable> extends GenericJpaDao{
    public GenericJpaDB1DAO(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre1");
    }
}
