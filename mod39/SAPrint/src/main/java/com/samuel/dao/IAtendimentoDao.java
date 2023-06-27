package com.samuel.dao;

import com.samuel.dao.generics.IGenericDao;
import com.samuel.exception.DaoException;
import com.samuel.model.Atendimento;

public interface IAtendimentoDao extends IGenericDao<Atendimento, Integer> {
    
    void finalizarAtendimento(Atendimento atendimento) throws DaoException;
    void cancelarAtendimento(Atendimento atendimento) throws DaoException;
    Atendimento consultarComCollection(Integer id);
}
