package com.samuel.dao;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.Venda;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDao extends GenericJpaDao<Venda, Long> implements IVendaJpaDao {

    public VendaExclusaoJpaDao() {
        super(Venda.class);
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public Venda consultarComCollection(Long id) {
        throw new UnsupportedOperationException("Operação não permitida.");
    }
}
