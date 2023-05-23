package com.samuel.dao;

import com.samuel.dao.generics.IGenericDao;
import com.samuel.exceptions.DaoExceptions;
import com.samuel.model.Atendimento;

public interface IAtendimentoDao extends IGenericDao<Atendimento, Integer> {
    
    void finalizarAtendimento(Atendimento atendimento) throws DaoExceptions;
    void cancelarAtendimento(Atendimento atendimento) throws DaoExceptions;
    Atendimento consultarComCollection(Integer id);
}
