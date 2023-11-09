package com.caramelobank.project.contas;

public class SaldoInsuficienteException extends RuntimeException{
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
