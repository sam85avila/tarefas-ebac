package com.samuel.services;

import com.samuel.dao.IProdutoJpaDao;
import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.domain.Produto;
import com.samuel.services.generic.jpa.GenericJpaService;

public class ProdutoService extends GenericJpaService<Produto, String> implements IProdutoService {
	public ProdutoService(IGenericJpaDao<Produto, String> genericJpaDao) {
		super(genericJpaDao);
	}

}
