package com.caramelobank.project.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.caramelobank.project.contas.DepositoNegativoException;
import com.caramelobank.project.contas.SaldoInsuficienteException;
import com.caramelobank.project.contas.TransferenciaException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_conta")
public abstract class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	private String agencia;
	private double saldo;
	private String senha;
	@OneToMany(mappedBy = "conta")
	protected Set<PessoaConta> pessoaConta = new HashSet<>();
	

	public Conta() {}
	
	public Conta(Long idConta, String agencia, double saldo, String senha) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	
	
//	Definindo métodos da class

	public void sacar(double valor) {
		if (this.saldo < valor || valor <= 0) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + 
					", Saque: " + valor);
		} else { 
			this.validarSenha(this.senha);
			this.saldo -= valor; }
		
	}
	
	
//	Este método realiza o depósito na conta
	
	public double deposita(double valor) throws DepositoNegativoException, TransferenciaException {
		if (valor > 0) {
			this.saldo += valor;
			return saldo;	
			
		} else {
			throw new DepositoNegativoException("valor Zero ou Negativo não vale como depósito");
		}
		
	}
	
	
//	Este método exibe o saldo da conta atual
	
	public double exibirSaldo() {
		return this.saldo;
	}
	
	
	
	public boolean validarSenha(String senhaTitular) {
		if (senhaTitular.equals(this.senha) == true) {
			return true;
		}
		
		return false;
	}
	
	
//	este método faz transferência da conta atual para a conta destino
	
	public boolean transfere(double valor, Conta destino) throws TransferenciaException, DepositoNegativoException{
		if (this.getSaldo() < valor || valor <= 0) {

			throw new TransferenciaException("Transferência inválida! Saldo: " + this.getSaldo() +
					", Transferência: " + valor);
			
		} else {  
			this.setSaldo(this.getSaldo() - valor);
			destino.deposita(valor);
			return true;
		}	
	}
	

	
//  Criado método get e set para manipular os atributos
	
	
	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senhaTitular) {
		this.senha = senhaTitular;
	}
		
	
}
