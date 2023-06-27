package com.samuel.dao;

import java.util.List;

import com.samuel.dao.generics.IGenericDao;
import com.samuel.model.Cliente;

public interface IClienteDao extends IGenericDao<Cliente, Integer> {
    
	
	List<Cliente> filtrarClientes(String query);
}
