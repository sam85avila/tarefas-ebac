package com.samuel.dao.generic.jpa;

import com.samuel.domain.jpa.Persistente;

import java.io.Serializable;

public abstract class GenericJpaDB3DAO <T extends Persistente, E extends Serializable> extends GenericJpaDao{
    public GenericJpaDB3DAO(Class persistenteClass) {
        super(persistenteClass, "Mysql1");
    }
}
