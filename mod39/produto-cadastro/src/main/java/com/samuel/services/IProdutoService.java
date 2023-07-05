package com.samuel.services;

import java.util.List;

import com.samuel.model.Produto;
import com.samuel.services.generics.IGenericService;

public interface IProdutoService extends IGenericService<Produto, Long> {
	
	List<Produto> filtrarProdutos(String query);
}
