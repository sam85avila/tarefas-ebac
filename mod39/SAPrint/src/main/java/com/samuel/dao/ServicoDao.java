package com.samuel.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.samuel.dao.generics.GenericDao;
import com.samuel.model.Servico;

public class ServicoDao extends GenericDao<Servico, Integer> implements IServicoDao{

    public ServicoDao() {
        super(Servico.class);
    }

	@Override
	public List<Servico> filtrarServicos(String query) {
		TypedQuery<Servico> tpQuery = 
				this.entityManager.createNamedQuery("Servico.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
    
    
    
}
