package contas;

import dadospessoais.Cliente;
import excecao.DepositoNegativoException;
import excecao.SaldoInsuficienteException;
import excecao.TransferenciaException;

public abstract class Conta{
	
	private int agencia;
	private int numero;
	private double saldo;
	private int senha;
	protected Cliente titular;
	
	
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
	
	public boolean transfere(double valor, Conta destino) throws TransferenciaException, DepositoNegativoException {
		if (this.saldo >= valor) {
			this.sacar(valor);
			destino.deposita(valor);
			return true;
			
		} else { throw new TransferenciaException("Procedimento inválido! Saldo: " + this.saldo +
				", Transferência: " + valor); }		
		
	}
	
	
//	Exibe dados e endereço do cliente
	
	public void exibirCliente() {
		this.titular.exibirTitular();
		this.titular.getEndereco().exibirEndereco();
	}
	

	
//  Criado método get e set para manipular os atributos
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular() {
		this.titular = new Cliente();
	}
}
