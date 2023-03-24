package dadospessoais;

import java.util.Scanner;

public class Endereco {

	private String rua;
	private int numero_rua;
	private String bairro;
	private String cep;
	private String uf;
	
	
	
//	Cadastra endereço do Cliente buscado
	
	public boolean cadastrarEndereco() {
		
		Scanner lerEndereco = new Scanner(System.in);
		
		System.out.printf("Rua: ");
		this.rua = lerEndereco.nextLine();

		System.out.printf("Nº_Rua: ");
		this.numero_rua = lerEndereco.nextInt();
		
//		Limpando buffer
		lerEndereco.nextLine();
		
		System.out.printf("Bairro: ");
		this.bairro = lerEndereco.nextLine();
		
		System.out.printf("CEP: ");
		this.cep = lerEndereco.nextLine();
		
		System.out.printf("UF: ");
		this.uf = lerEndereco.nextLine();
		
		return true;
	}
	
//	Exibe Endereco do cliente buscado
	
	public void exibirEndereco(){
		
		System.out.println("Rua: " + this.getRua());
		System.out.println("Nº: " + this.getNumero_rua());
		System.out.println("Bairro: " + this.getBairro());
		System.out.println("CEP: " + this.getCep());
		System.out.println("UF: " + this.getUf());
	}
	
	
//  Criado método get e set para manipular os atributos
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero_rua() {
		return numero_rua;
	}
	public void setNumero_rua(int numero_rua) {
		this.numero_rua = numero_rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
}
