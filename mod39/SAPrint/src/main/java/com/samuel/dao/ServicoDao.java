package com.samuel.dao;

import com.samuel.dao.generics.GenericDao;
import com.samuel.model.Servico;

public class ServicoDao extends GenericDao<Servico, Integer> implements IServicoDao{

    public ServicoDao(Class<Servico> persistenteClass) {
        super(Servico.class);
    }
    
}
