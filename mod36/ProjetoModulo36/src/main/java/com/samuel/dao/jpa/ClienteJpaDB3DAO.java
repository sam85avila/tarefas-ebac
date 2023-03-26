package com.samuel.dao.jpa;

import com.samuel.dao.generic.jpa.GenericJpaDB3DAO;
import com.samuel.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDao<ClienteJpa2> {
    public ClienteJpaDB3DAO() {
        super(ClienteJpa2.class);
    }
}
