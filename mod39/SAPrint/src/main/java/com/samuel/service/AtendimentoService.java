package com.samuel.service;

import com.samuel.dao.IAtendimentoDao;
import com.samuel.exception.DaoException;
import com.samuel.model.Atendimento;
import com.samuel.model.Atendimento.Status;
import com.samuel.service.generic.GenericService;

public class AtendimentoService extends GenericService<Atendimento, Integer> implements IAtendimentoService{

	private IAtendimentoDao atendimentoDao;

	public AtendimentoService(IAtendimentoDao atendimentoDao) {
		super(atendimentoDao);
		this.atendimentoDao = atendimentoDao;
	}

	@Override
	public void finalizarAtendimento(Atendimento atendimento) throws DaoException {
		atendimento.setStatus(Status.FINALIZADO);
		atendimentoDao.finalizarAtendimento(atendimento);
		
	}

	@Override
	public void cancelarAtendimento(Atendimento atendimento) throws DaoException {
		atendimento.setStatus(Status.CANCELADO);
		atendimentoDao.cancelarAtendimento(atendimento);
	}

	@Override
	public Atendimento consultarComCollection(Integer id) {
		return atendimentoDao.consultarComCollection(id);
	}

	@Override
	public Atendimento cadastrar(Atendimento entity) throws DaoException {
		entity.setStatus(Status.INICIADO);
		return super.cadastrar(entity);
	}
	
}
