package com.samuel.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.samuel.dao.generic.GenericDAO;
import com.samuel.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO{

	public ProdutoDAO() {
		super(Produto.class);
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		TypedQuery<Produto> tpQuery = 
				this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
	
}
