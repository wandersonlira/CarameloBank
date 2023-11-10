package com.caramelobank.project.contas;

public abstract interface Tributaveis {

	void tributoSaca(double valorSacar);
	void tributoTransferencia(double valorTransfere);
}
