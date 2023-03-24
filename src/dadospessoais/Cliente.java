package dadospessoais;

import java.util.Scanner;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String profissao;
	private int idade;
	protected Endereco endereco;
	
	
//	Cadastra os dados do Cliente buscado
	
	public void cadastrarCliente() {
		
		Scanner lerTeclado = new Scanner(System.in);
		
		System.out.printf("Nome: ");
		this.nome = lerTeclado.nextLine();
		
		System.out.printf("CPF: ");
		this.cpf = lerTeclado.nextLine();
		
		System.out.printf("Profissão: ");
		this.profissao = lerTeclado.nextLine();
		
		System.out.printf("Idade: ");
		this.idade = lerTeclado.nextInt();
		
//		chama o cadastro da outra class
		this.endereco.cadastrarEndereco();

	}
	
//	Exibe os dados do Cliente buscado
	
	public void exibirTitular() {
		
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Profissão: " + this.getProfissao());
		System.out.println("Idade: " + this.getIdade());
	}
	
	
//  Criado método get e set para manipular os atributos
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEndereco() {
		this.endereco = new Endereco();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	

}
