package com.samuel.dao.jpa;

import com.samuel.dao.generic.jpa.GenericJpaDB2DAO;
import com.samuel.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDao<ClienteJpa>{
    public ClienteJpaDB2DAO() {
        super(ClienteJpa.class);
    }
}
