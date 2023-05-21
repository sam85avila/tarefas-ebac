package com.samuel.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_servico_quantidade")
public class ServicoQuantidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_quantidade_seq")
	@SequenceGenerator(name = "servico_quantidade_seq", sequenceName = "seq_servico_quantidade",
						initialValue = 1, allocationSize = 1)
	private Integer id;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Servico servico;
	
	private Integer quantidade;
	
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_atendimento_fk",
				foreignKey = @ForeignKey(name = "fk_serv_quant_atendimento"),
				referencedColumnName = "id",
				nullable = false)
	private Atendimento atendimento;

	public ServicoQuantidade() {
		this.quantidade = 0;
		valorTotal = BigDecimal.ZERO;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade = quantidade;
		BigDecimal novoValor = this.servico.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;		
	}

	public void remover(Integer quantidade) {
		this.quantidade = quantidade;
		BigDecimal novoValor = this.servico.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}

	//Getters - Setters
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
		return quantidade;
	}

	public void setQuatidade(Integer quantidade) {
		this.quantidade = quantidade;
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
