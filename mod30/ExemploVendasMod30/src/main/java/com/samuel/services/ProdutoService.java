package com.samuel.services;

import com.samuel.dao.IProdutoDAO;
import com.samuel.domain.Produto;
import com.samuel.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
