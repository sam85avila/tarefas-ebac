package com.samuel.dao.jpa;

import com.samuel.dao.generic.IGenericJpaDao;
import com.samuel.domain.jpa.VendaJpa;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDao extends IGenericJpaDao<VendaJpa, Long> {
    void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
    void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
    VendaJpa consultarComCollection(Long id);
}
