package contas;

import dadospessoais.Cliente;
import excecao.DepositoNegativoException;

public abstract class Conta{
	
	private int agencia;
	private int numero;
	private double saldo;
	private int senha;
	protected Cliente titular;
	
	
//	Definindo métodos da class
	
	abstract boolean sacar(double valor);
//		if (this.saldo >= valor) {
//			this.saldo -= valor;
//			return true;
//		}
//		
//		return false;
//	}
	
	
//	Este método realiza o depósito na conta
	
	public double deposita(double valor) throws DepositoNegativoException {
		if (valor > 0) {
			this.saldo += valor;
			return saldo;	
			
		} else {
			throw new DepositoNegativoException("valor zero ou negativo não vale como depósito");
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
	
	public boolean transfere(double valor, Conta destino) throws DepositoNegativoException{
		if (this.saldo >= valor) {
			if (validarSenha(getSenha()) == true) {
				this.saldo -= valor;
				destino.deposita(valor);
				return true;
			}

		}
		
		return false; // irei implementar o retorno de uma exception
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
