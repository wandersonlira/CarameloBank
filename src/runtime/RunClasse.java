package runtime;

import contas.ContaCorrente;
import contas.ContaPoupanca;
//import excecao.DepositoNegativoException;

public class RunClasse {
	
	public static void main(String[] args) {
		
		ContaCorrente contaWanderson = new ContaCorrente(540, 88, 134);
		
		
		contaWanderson.setTitular();
		contaWanderson.getTitular().setEndereco();
		
		ContaPoupanca contaRaquel = new ContaPoupanca();
		
		try {
			contaRaquel.deposita(100);
			
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println("Raquel Exception: " + msg);
			ex.printStackTrace();
			
		}
		
		
		System.out.println("Raquel Saldo anterior: " + contaRaquel.exibirSaldo());
		
		
		try {
			contaWanderson.deposita(10);
			
		} catch(Exception ex) {
			String msg = ex.getMessage();
			System.out.println("Exception: " + msg);
			ex.printStackTrace();
		}
		
		System.out.println("Wanderson Saldo anterior: " + contaWanderson.exibirSaldo());
			
		
		try {
				contaRaquel.transfere(5, contaWanderson);		

				
			} catch (Exception ex) {
				
				String msg = ex.getMessage();
				System.out.println("Exception: " + msg);
				ex.printStackTrace();
			}
		
		
//	contaRaquel.sacar(10);
		

		//conta.getTitular().cadastrar();
		
		
		//contaWanderson.exibirCliente();
//		
//		System.out.println("Agência: " + conta.getAgencia());
//		System.out.println("Número: " + conta.getNumero());
	//	System.out.println("Nome: " + contaWanderson.getTitular().getNome());
//		System.out.println("CPF: " + conta.getTitular().getCpf());
//		System.out.println("Profissão: " + conta.getTitular().getProfissao());
//		System.out.println("Idade: " + conta.getTitular().getIdade());
//		System.out.println("Rua: " + conta.getTitular().getEndereco().getRua());
;
	//	System.out.println("Senha correta? " + contaWanderson.validarSenha(134));
//		System.out.println("Deposito: " + contaWanderson.exibirSaldo());
//		System.out.println("Sacou?: " + contaWanderson.sacar(65));
		System.out.println("Raquel Saldo atual: " + contaRaquel.exibirSaldo());
		System.out.println("Wanderson Saldo atual: " + contaWanderson.exibirSaldo());
		
		


		

	}

}
