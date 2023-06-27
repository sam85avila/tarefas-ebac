package com.samuel.dao;

import java.util.List;

import com.samuel.dao.generics.IGenericDao;
import com.samuel.model.Servico;

public interface IServicoDao extends IGenericDao<Servico, Integer>{
    
	List<Servico> filtrarServicos(String query);
}
