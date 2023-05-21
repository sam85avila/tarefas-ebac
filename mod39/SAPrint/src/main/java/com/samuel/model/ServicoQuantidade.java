package com.samuel.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ServicoQuantidade {
	
	private Integer id;
	private Servico servico;
	private Integer quatidade;
	private BigDecimal valorTotal;
	private Atendimento atendimento;
	
	public ServicoQuantidade() {
		
	}

	public ServicoQuantidade(Servico servico, Integer quatidade, BigDecimal valorTotal, Atendimento atendimento) {
		this.servico = servico;
		this.quatidade = quatidade;
		this.valorTotal = valorTotal;
		this.atendimento = atendimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getQuatidade() {
		return quatidade;
	}

	public void setQuatidade(Integer quatidade) {
		this.quatidade = quatidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoQuantidade other = (ServicoQuantidade) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
