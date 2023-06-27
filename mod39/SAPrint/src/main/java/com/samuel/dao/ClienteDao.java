package com.samuel.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.samuel.dao.generics.GenericDao;
import com.samuel.model.Cliente;

public class ClienteDao extends GenericDao<Cliente, Integer> implements IClienteDao{

    public ClienteDao(Class<Cliente> persistenteClass) {
        super(Cliente.class);
    }
    
    public List<Cliente> filtrarClientes(String query) {
		TypedQuery<Cliente> tpQuery = 
				this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
		
	}
    
}
