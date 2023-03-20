package com.samuel.dao;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.Cliente;

public class ClienteJpaDao extends GenericJpaDao<Cliente, Long> implements IClienteJpaDao {
    public ClienteJpaDao() {
        super(Cliente.class);
    }

}
