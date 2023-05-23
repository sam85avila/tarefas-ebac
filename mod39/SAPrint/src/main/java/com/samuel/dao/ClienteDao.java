package com.samuel.dao;

import com.samuel.dao.generics.GenericDao;
import com.samuel.model.Cliente;

public class ClienteDao extends GenericDao<Cliente, Integer> implements IClienteDao{

    public ClienteDao(Class<Cliente> persistenteClass) {
        super(Cliente.class);
    }
    
}
