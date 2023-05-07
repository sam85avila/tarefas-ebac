package com.samuel.dao.jpa;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDao<ProdutoJpa, Long> implements IProdutoJpaDao {
    public ProdutoJpaDao() {
        super(ProdutoJpa.class);
    }
}
