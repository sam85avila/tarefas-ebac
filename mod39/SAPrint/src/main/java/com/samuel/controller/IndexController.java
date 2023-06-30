package com.samuel.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "indexMB")
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String redirectCliente() {
		return "/cliente/list.xhtml";
	}
	
	public String redirectServico() {
		return "/servico/list.xhtml";
	}
	
	public String redirectAtendimento() {
		return "/atendimento/list.xhtml";
	}

}
