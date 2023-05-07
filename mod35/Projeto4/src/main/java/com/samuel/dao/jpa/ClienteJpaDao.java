package com.samuel.dao.jpa;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.jpa.ClienteJpa;


public class ClienteJpaDao extends GenericJpaDao<ClienteJpa, Long> implements IClienteJpaDao {
    public ClienteJpaDao() {
        super(ClienteJpa.class);
    }

}
