package com.samuel.dao.jpa;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.jpa.VendaJpa;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDao extends GenericJpaDao<VendaJpa, Long> implements IVendaJpaDao {

    public VendaExclusaoJpaDao() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("Operação não permitida.");
    }
}
