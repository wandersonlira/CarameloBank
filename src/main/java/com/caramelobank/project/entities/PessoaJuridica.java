package com.caramelobank.project.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_pj")
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String pj;
	
	
	public PessoaJuridica() {}

	public PessoaJuridica(String pj) {
		super();
		this.pj = pj;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pj);
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
		return Objects.equals(pj, other.pj);
	}

	

	public String getPj() {
		return pj;
	}

	public void setPj(String pj) {
		this.pj = pj;
	}


	@Override
	public String toString() {
		return "PessoaJuridica [pj=" + pj + "]";
	}
	
	

}
