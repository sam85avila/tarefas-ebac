package com.samuel.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuel.dao.IServicoDao;
import com.samuel.model.Servico;
import com.samuel.service.generic.GenericService;

@Stateless
public class ServicoService extends GenericService<Servico, Integer> implements IServicoService {

	private IServicoDao servicoDao;
	
	@Inject
	public ServicoService(IServicoDao servicoDao) {
		super(servicoDao);
		this.servicoDao = servicoDao;
	}

	@Override
	public List<Servico> filtrarServico(String query) {
		return servicoDao.filtrarServicos(query);
	}
	
}
