package com.caramelobank.contas;

public abstract interface Tributaveis {

	void tributoSaca(double valorSacar);
	
	void tributoTransferencia(double valorTransfere);
}
