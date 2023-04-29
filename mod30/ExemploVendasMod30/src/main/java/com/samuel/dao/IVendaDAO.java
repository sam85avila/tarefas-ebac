package com.samuel.dao;

import com.samuel.dao.generic.IGenericDAO;
import com.samuel.domain.Venda;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
