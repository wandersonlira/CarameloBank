package com.caramelobank.project.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_cnpj")
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	
	public PessoaJuridica() {}

	public PessoaJuridica(String cnpj) {
		super();
		this.cnpj = cnpj;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String pj) {
		this.cnpj = pj;
	}


	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + "]";
	}
	
	

}
