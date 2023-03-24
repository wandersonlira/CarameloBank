package contas;

public class ContaPoupanca extends Conta{
	
	
//	Definindo Construtores
	
	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, int numero, int senhaTitular) {
		super();
		this.setAgencia(agencia);
		this.setNumero(numero);
		this.setSenha(senhaTitular);
	}

	
//	sobreescrevendo métodos
	
	@Override
	public boolean sacar(double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo((getSaldo() - valor) - (0.2 * valor));
			return true;
		}
		return false;
	}
	

}
