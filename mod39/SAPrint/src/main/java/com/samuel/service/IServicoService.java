package com.samuel.service;

import java.util.List;

import com.samuel.model.Servico;
import com.samuel.service.generic.IGenericService;

public interface IServicoService extends IGenericService<Servico, Integer> {
	
	List<Servico> filtrarServico(String query);
}
