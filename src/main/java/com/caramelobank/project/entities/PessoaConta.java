package com.caramelobank.project.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_pessoa_conta")
public class PessoaConta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoaConta;
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;


	public PessoaConta() {}
	
	public PessoaConta(Long idPessoaConta, Pessoa pessoa, Conta conta) {
		super();
		this.idPessoaConta = idPessoaConta;
		this.pessoa = pessoa;
		this.conta = conta;
	}
	
	
	
	public Long getIdPessoaContaPK() {
		return idPessoaConta;
	}
	public void setIdPessoaContaPK(Long idPessoaConta) {
		this.idPessoaConta = idPessoaConta;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(conta, idPessoaConta, pessoa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaConta other = (PessoaConta) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(idPessoaConta, other.idPessoaConta)
				&& Objects.equals(pessoa, other.pessoa);
	}
	
	
	
	
	
}
