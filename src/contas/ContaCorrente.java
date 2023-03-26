package contas;

public class ContaCorrente extends Conta {
	

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
		super.sacar(valor);
//		if (this.getSaldo() >= valor) {
//			this.setSaldo((getSaldo() - valor) - (0.1 * valor));
//			return true;
//		}
//		return false;
	}

	
	

	
}
