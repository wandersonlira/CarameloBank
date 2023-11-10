package com.caramelobank.project.entities;

import com.caramelobank.project.contas.DepositoNegativoException;
import com.caramelobank.project.contas.SaldoInsuficienteException;
import com.caramelobank.project.contas.TransferenciaException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tab_conta")
public abstract class Conta{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	private Integer agencia;
	private double saldo;
	private Integer senha;
	protected Pessoa titular;
	
	
	public Conta() {}
	
	public Conta(Long idConta, Integer agencia, double saldo, Integer senha, Pessoa titular) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.senha = senha;
		this.titular = titular;
	}
	
	
	
//	Definindo métodos da class

	public void sacar(double valor) {
		if (this.saldo < valor || valor <= 0) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + 
					", Saque: " + valor);
		} else { 
			this.validarSenha(getSenha());
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
	
	
//	public void cadastrarConta() {
//		
//		
//	}
	
	
	public boolean validarSenha(int senhaTitular) {
		if (senhaTitular == this.getSenha()) {
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
	
	
//	Exibe dados e endereço do cliente
	
//	public void exibirCliente() {
//		this.titular.exibirTitular();
//		this.titular.getEndereco().exibirEndereco();
//	}

	
//  Criado método get e set para manipular os atributos
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senhaTitular) {
		this.senha = senhaTitular;
	}

	public Pessoa getTitular() {
		return titular;
	}
	
	public void setTitular() {
		this.titular = new Pessoa();
	}


	public Long getIdConta() {
		return idConta;
	}


	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
}
