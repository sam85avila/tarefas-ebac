package com.samuel.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.samuel.exception.DaoException;
import com.samuel.exception.NegocioException;
import com.samuel.model.Servico;
import com.samuel.service.IServicoService;
import com.samuel.utility.Message;

@Named(value = "servicoMB")
@ViewScoped
public class ServicoControle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Servico servico;
	
	@Inject
	private IServicoService service;
	
	private Collection<Servico> servicos;
	
	@PostConstruct
	public void init() throws NegocioException, DaoException {
		servicos = service.buscarTodos();
	}
	
	public void adicionar() throws DaoException {
		try {
			service.cadastrar(servico);
			servico = new Servico();
			init();
			Message.info("Salvo com sucesso");
			
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
	
	public void excluir() throws DaoException {
		try {
			service.excluir(servico);
			init();
			Message.info(servico.getNome() + " foi removido com sucesso.");
			
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Collection<Servico> getServicos() {
		return servicos;
	}
}
