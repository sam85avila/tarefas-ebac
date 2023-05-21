package com.samuel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Atendimento implements Persistente, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Set<Servico> servicos;
	private Cliente cliente;
	private Instant dataAtendimento;
	private Status status;
	private BigDecimal valorTotal;
	
	public Atendimento() {
		servicos = new HashSet<>();
	}

	public Atendimento(Set<Servico> serviços, Cliente cliente) {
		this.servicos = serviços;
		this.cliente = cliente;
	}
	
	public BigDecimal calcularTotalServicos(Set<Servico> servicos) {
		BigDecimal total = BigDecimal.ZERO;
		for (Servico servico : servicos) {
			total.add(servico.getValor());
		}
		return total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Servico> getServiços() {
		return servicos;
	}

	public void setServiços(Set<Servico> serviços) {
		this.servicos = serviços;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public Instant getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Instant dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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
		Atendimento other = (Atendimento) obj;
		return Objects.equals(id, other.id);
	}
	
	public static enum Status {
		INICIADO, FINALIZADO, CANCELADO;
	}
	
}
