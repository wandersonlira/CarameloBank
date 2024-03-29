package com.caramelobank.project.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_cliente")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String profissao;
	private LocalDate dataNascimento;
	@ManyToOne
	@JoinColumn(name = "codigo_endereco_id")
	private Endereco tabEndereco;
	@OneToMany(mappedBy = "pessoa")
	private Set<PessoaConta> pessoaConta = new HashSet<>();

	

	public Pessoa() {}
	
	
	public Pessoa(Long idCliente, String nome, String cpf, String email, String profissao, 
			LocalDate dataNascimento, Endereco tabEndereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.profissao = profissao;
		this.dataNascimento = dataNascimento;
		this.tabEndereco = tabEndereco;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, idCliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(idCliente, other.idCliente);
	}


	
	public Long getId() {
		return idCliente;
	}


	public void setId(Long id) {
		this.idCliente = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProfissao() {
		return profissao;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}



	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Endereco getEndereco() {
		return tabEndereco;
	}


	public void setEndereco(Endereco endereco) {
		this.tabEndereco = endereco;
	}
	

	public Set<Conta> getConta() {
		Set<Conta> setConta = new HashSet<Conta>();
		for (PessoaConta pessoaConta : pessoaConta) {
			setConta.add(pessoaConta.getConta());
		}
		return setConta;
	}

	

	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", profissao=" + profissao
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + tabEndereco +  "]";
	}
	

}
