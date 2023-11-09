package com.caramelobank.project.contas;

public class ContaCorrente extends Conta implements Tributaveis{
	
	private static final double TRIBUTO_SACAR = 0.1;
	private static final double TRIBUTO_TRANSFERE = 0.1;
	

//	Definindo Construtores
	
	public ContaCorrente() {}

	public ContaCorrente(int agencia, int numero, int senhaTitular) {
		super();
		this.setAgencia(agencia);
		this.setNumero(numero);	
		this.setSenha(senhaTitular);
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

	

	
}
