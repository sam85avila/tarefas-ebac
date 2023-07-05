package com.samuel.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuel.dao.IProdutoDAO;
import com.samuel.model.Produto;
import com.samuel.services.generics.GenericService;

@Stateless
public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {

	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}
}
