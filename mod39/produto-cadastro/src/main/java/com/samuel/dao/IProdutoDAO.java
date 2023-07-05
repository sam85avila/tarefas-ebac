package com.samuel.dao;

import java.util.List;

import com.samuel.dao.generic.IGenericDAO;
import com.samuel.model.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, Long>{

	List<Produto> filtrarProdutos(String query);

}
