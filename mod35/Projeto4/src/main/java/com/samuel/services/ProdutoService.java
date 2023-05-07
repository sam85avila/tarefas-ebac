package com.samuel.services;

import com.samuel.dao.generic.IGenericDAO;
import com.samuel.domain.Produto;
import com.samuel.exceptions.DAOException;
import com.samuel.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	public ProdutoService(IGenericDAO<Produto, String> genericJpaDao) {
		super(genericJpaDao);
	}

	@Override
	public void excluir(String valor) throws DAOException {

	}
}
