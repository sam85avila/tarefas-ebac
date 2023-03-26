package com.samuel.dao.jpa;

import com.samuel.dao.generic.jpa.GenericJpaDB1DAO;
import com.samuel.dao.generic.jpa.GenericJpaDao;
import com.samuel.domain.jpa.ClienteJpa;


public class ClienteJpaDao extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDao<ClienteJpa> {
    public ClienteJpaDao() {
        super(ClienteJpa.class);
    }
}
