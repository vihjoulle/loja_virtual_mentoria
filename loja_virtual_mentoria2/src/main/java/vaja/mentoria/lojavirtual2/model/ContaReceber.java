package vaja.mentoria.lojavirtual2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import vaja.mentoria.lojavirtual2.enums.StatusContaReceber;

@Entity
@Table(name = "conta_receber")
@SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
	private Long id;

	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusContaReceber status;
	
	private Date dtVencimento;
	
	
	@Temporal(TemporalType.DATE)
	private Date dtPagamento;
	
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public StatusContaReceber getStatus() {
		return status;
	}



	public void setStatus(StatusContaReceber status) {
		this.status = status;
	}



	public Date getDtVencimento() {
		return dtVencimento;
	}



	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}



	public Date getDtPagamento() {
		return dtPagamento;
	}



	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}



	public BigDecimal getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}



	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}



	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	@Override
	public int hashCode() {
		return Objects.hash(descricao, dtPagamento, dtVencimento, id, pessoa, status, valorDesconto, valorTotal);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaReceber other = (ContaReceber) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(dtPagamento, other.dtPagamento)
				&& Objects.equals(dtVencimento, other.dtVencimento) && Objects.equals(id, other.id)
				&& Objects.equals(pessoa, other.pessoa) && status == other.status
				&& Objects.equals(valorDesconto, other.valorDesconto) && Objects.equals(valorTotal, other.valorTotal);
	}



	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
}
