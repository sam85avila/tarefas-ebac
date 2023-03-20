package com.samuel.dao;

import com.samuel.dao.generic.GenericJpaDao;
import com.samuel.domain.Produto;

public class ProdutoJpaDao extends GenericJpaDao<Produto, Long> implements IProdutoJpaDao {
    public ProdutoJpaDao() {
        super(Produto.class);
    }
}
