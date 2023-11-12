package com.caramelobank.project.entities;

import java.io.Serializable;
import java.util.Objects;

import com.caramelobank.project.contas.DepositoNegativoException;
import com.caramelobank.project.contas.SaldoInsuficienteException;
import com.caramelobank.project.contas.TransferenciaException;
import com.caramelobank.project.contas.Tributaveis;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_contaPoupanca")
public class ContaPoupanca extends Conta implements Tributaveis, Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final double TRIBUTO_SACAR = 0.2;
	private static final double TRIBUTO_TRANSFERE = 0.2;
	
	private Integer numeroPoupanca;
	

	
	public ContaPoupanca() {}
		
	public ContaPoupanca(Integer numeroPoupanca) {
	super();
	this.numeroPoupanca = numeroPoupanca;
}

	
//	sobreescrevendo métodos
	
	@Override
	public void sacar(double valor) {
		this.tributoSaca(valor);
			super.sacar(valor);	
	}
	
	

	@Override
	public boolean transfere(double valor, Conta destino) throws TransferenciaException, DepositoNegativoException {
		this.tributoTransferencia(valor);
		return super.transfere(valor, destino);
	}

	
	
	@Override
	public void tributoSaca(double valorSacar) {
		if (this.getSaldo() < (valorSacar + (TRIBUTO_SACAR * valorSacar)) || valorSacar <= 0) {
			
			throw new SaldoInsuficienteException("Saque Inválidooo! Saldo: " + getSaldo() +
					", Valor + Tributo: " + (valorSacar + (TRIBUTO_SACAR * valorSacar)));
			
		} else { 
			this.setSaldo(this.getSaldo() - (TRIBUTO_SACAR * valorSacar));
			}
	}
	
	
	
	@Override
	public void tributoTransferencia(double valorTransfere) {
		if (this.getSaldo() < (valorTransfere + (TRIBUTO_TRANSFERE * valorTransfere)) || valorTransfere <= 0) {
			
			throw new SaldoInsuficienteException("Transferência inválidaaaa! Saldo: " + getSaldo() +
					", Transferência + Tributo: " + (valorTransfere + (TRIBUTO_TRANSFERE * valorTransfere)));
			
		} else { 
			this.setSaldo(this.getSaldo() - (TRIBUTO_TRANSFERE * valorTransfere));
			}
		
	}
	
	
	
//  hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroPoupanca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPoupanca other = (ContaPoupanca) obj;
		return numeroPoupanca == other.numeroPoupanca;
	}
	
	
	
//  Getters e Setters

	public Integer getNumeroPoupanca() {
		return numeroPoupanca;
	}

	public void setNumeroPoupanca(Integer numeroPoupanca) {
		this.numeroPoupanca = numeroPoupanca;
	}
	

}
