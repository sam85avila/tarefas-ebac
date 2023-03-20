package com.samuel.dao;

import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.domain.Venda;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDao extends IGenericJpaDao<Venda, Long> {
    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
    Venda consultarComCollection(Long id);
}
