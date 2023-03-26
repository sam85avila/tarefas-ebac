package com.samuel.dao.jpa;

import com.samuel.dao.generic.jpa.GenericJpaDB1DAO;
import com.samuel.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDao {
    public ProdutoJpaDao() {
        super(ProdutoJpa.class);
    }
}
