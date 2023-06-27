package com.samuel.service;

import com.samuel.exception.DaoException;
import com.samuel.model.Atendimento;
import com.samuel.service.generic.IGenericService;

public interface IAtendimentoService extends IGenericService<Atendimento, Integer> {

	void finalizarAtendimento(Atendimento atendimento) throws DaoException;
	void cancelarAtendimento(Atendimento atendimento) throws DaoException;
	Atendimento consultarComCollection(Integer id);
}
