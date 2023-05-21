package com.samuel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento implements Persistente, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="atendimento_seq")
	@SequenceGenerator(name="atendimento_seq", sequenceName="sq_atendimento", initialValue = 1, allocationSize = 1)
	private Integer id;

	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ServicoQuantidade> servicos;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", 
				foreignKey = @ForeignKey(name = "fk_atendimento_cliente"), 
				referencedColumnName = "id", nullable = false
				)
	private Cliente cliente;

	private Instant dataAtendimento;
	private Status status;
	private BigDecimal valorTotal;
	

	public Atendimento() {
		servicos = new HashSet<>();
	}

	public Atendimento(Set<ServicoQuantidade> servico, Cliente cliente) {
		this.servicos = servico;
		this.cliente = cliente;
	}
	
	private void validarStatus() {
		if (this.status == Status.FINALIZADO) {
			throw new UnsupportedOperationException("Impossível Alterar Atendimento Finalizado.");
		}
	}

	public void adicionarServico(Servico servico, Integer quantidade) {
		validarStatus();
		Optional<ServicoQuantidade> optional = this.servicos.stream().filter(s -> 
			s.getServico().getId().equals(servico.getId())).findAny();
		if(optional.isPresent()) {
			ServicoQuantidade servicoQuantidade = optional.get();
			servicoQuantidade.adicionar(quantidade);
		} else {
			ServicoQuantidade serv = criarServicoQuantidade(servico, quantidade);
			servicos.add(serv);
		}
		recalcularValorTotalAtendimento();
	}

	public void removerServico(Servico servico, Integer quantidade) {
		validarStatus();
		Optional<ServicoQuantidade> optional = this.servicos.stream().filter(s -> 
		s.getServico().getId().equals(servico.getId())).findAny();
		if (optional.isPresent()) {
			ServicoQuantidade sq = optional.get();
			if (sq.getQuatidade() > quantidade) {
				sq.remover(quantidade);
				recalcularValorTotalAtendimento();
			} else {
				servicos.remove(optional.get());
				recalcularValorTotalAtendimento();
			}
		}
	}

	public void removerTodosServicos() {
		validarStatus();
		servicos.clear();
		valorTotal = BigDecimal.ZERO;
	}

	/**
	 * Soma a quantidade getQuantidade() de todos os objetos ServicoQuantidade.
	 */
	public Integer getQuantidadeTotalServicos() {
		int resultado = servicos.stream().reduce(0, (r, s) -> r + s.getQuatidade(), Integer::sum);		
		return resultado;
	}

	private void recalcularValorTotalAtendimento() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (ServicoQuantidade sq : servicos) {
			valorTotal = valorTotal.add(sq.getValorTotal());
		}
		this.valorTotal = valorTotal;
	}

	private ServicoQuantidade criarServicoQuantidade(Servico servico, Integer quantidade) {
		ServicoQuantidade serv = new ServicoQuantidade();
		serv.setAtendimento(this);
		serv.setServico(servico);
		serv.adicionar(quantidade);
		return serv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ServicoQuantidade> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoQuantidade> servicos) {
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
