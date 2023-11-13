package com.caramelobank.project.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caramelobank.project.entities.ContaCorrente;
import com.caramelobank.project.entities.ContaPoupanca;
import com.caramelobank.project.entities.Endereco;
import com.caramelobank.project.entities.Pessoa;
import com.caramelobank.project.entities.PessoaConta;
import com.caramelobank.project.entities.PessoaJuridica;
import com.caramelobank.project.repositories.ContaCorrenteRepository;
import com.caramelobank.project.repositories.ContaPoupancaRepository;
import com.caramelobank.project.repositories.EnderecoRepository;
import com.caramelobank.project.repositories.PessoaContaRepository;
import com.caramelobank.project.repositories.PessoaJuridicaRepository;
import com.caramelobank.project.repositories.PessoaRepository;
import com.caramelobank.project.viacep.ConsultaCepAPI;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	private ContaPoupancaRepository contaPoupancaRepository;
	@Autowired
	private PessoaContaRepository pessoaContaPKRepository;
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		Endereco endereco3 = new Endereco();
		Endereco endereco4 = new Endereco();
		
		ConsultaCepAPI api = new ConsultaCepAPI();
		
		endereco1 = api.consultaCep("50630160");
		endereco2 = api.consultaCep("54400020");
		endereco3 = api.consultaCep("50670901");
		endereco4 = api.consultaCep("48610572");
		
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3, endereco4));
		
//		----------------------- contaCorrente ------------------------------
		ContaCorrente contaCorrenteMusk = new ContaCorrente();
		
		contaCorrenteMusk.setAgencia("00251");
		contaCorrenteMusk.setNumeroCorrente(987);
		contaCorrenteMusk.setSaldo(120.50);
		contaCorrenteMusk.setSenha("elo123456");
		
		
		ContaCorrente contaCorrenteMadona = new ContaCorrente();
		
		contaCorrenteMadona.setAgencia("00251");
		contaCorrenteMadona.setNumeroCorrente(988);
		contaCorrenteMadona.setSaldo(230.10);
		contaCorrenteMadona.setSenha("mad123456");
		
		
		ContaCorrente contaCorrenteNeymar = new ContaCorrente();
		
		contaCorrenteNeymar.setAgencia("00555");
		contaCorrenteNeymar.setNumeroCorrente(989);
		contaCorrenteNeymar.setSaldo(13.70);
		contaCorrenteNeymar.setSenha("ney123456");
		
		contaCorrenteRepository.saveAll(Arrays.asList(contaCorrenteMusk, contaCorrenteMadona, contaCorrenteNeymar));
		
//		------------------------ contaPoupanca -----------------------------
		ContaPoupanca contaPoupancaLenin = new ContaPoupanca();
		
		contaPoupancaLenin.setAgencia("354");
		contaPoupancaLenin.setNumeroPoupanca(221);
		contaPoupancaLenin.setSaldo(52.87);
		contaPoupancaLenin.setSenha("len1234567");
		
		
		ContaPoupanca contaPoupancaMadona = new ContaPoupanca();
		
		contaPoupancaMadona.setAgencia("00251");
		contaPoupancaMadona.setNumeroPoupanca(222);
		contaPoupancaMadona.setSaldo(30.45);
		contaPoupancaMadona.setSenha("mad123456");
		
		contaPoupancaRepository.saveAll(Arrays.asList(contaPoupancaLenin, contaPoupancaMadona));
		
//		-------------------------- Pessoa -------------------------------
		Pessoa elonMusk = new Pessoa(null, "Elon Musk", "00000000001", "bilionario@musk.com", "Ser Bilionário",
				LocalDate.parse("1982-04-15"), endereco3);
		
		Pessoa lenin = new Pessoa(null, "Lenin", "00000000002", "uniao@lenin.com", "Comunista",
				LocalDate.parse("1911-10-20"), endereco2);
		
		Pessoa madona = new Pessoa(null, "Madona", "00000000003", "cantora@madona.com", "Cantora",
				LocalDate.parse("1979-02-11"), endereco1);
		

		pessoaRepository.saveAll(Arrays.asList(elonMusk, lenin, madona));
		
//		----------------------------- Pessoa Juridica ------------------------
		PessoaJuridica neymar = new PessoaJuridica();
		
		neymar.setNome("Neymar");
		neymar.setCpf("00000000004");
		neymar.setCnpj("99.999.999/0001-01");
		neymar.setEmail("jogador@neymar.com");
		neymar.setProfissao( "jogador");
		neymar.setDataNascimento(LocalDate.parse("1992-02-05"));
		neymar.setEndereco(endereco4);
		
		pessoaJuridicaRepository.saveAll(Arrays.asList(neymar));
		
//		-------------------------- PessoaConta -----------------------------
		PessoaConta pessoaContaMusk = new PessoaConta(null, elonMusk, contaCorrenteMusk);
		PessoaConta pessoaContaLenin= new PessoaConta(null, lenin, contaPoupancaLenin);		
		PessoaConta pessoaContaMadonaCorrente = new PessoaConta(null, madona, contaCorrenteMadona);
		PessoaConta pessoaContaMadonaPoupanca = new PessoaConta(null, madona, contaPoupancaMadona);
		PessoaConta pessoaContaNeymarPJ= new PessoaConta(null, neymar, contaCorrenteNeymar);
		
		pessoaContaPKRepository.saveAll(Arrays.asList(pessoaContaMusk, pessoaContaLenin, pessoaContaMadonaCorrente, 
				pessoaContaMadonaPoupanca, pessoaContaNeymarPJ));
		

		
		System.out.println("PRONTO!!");
		
		
		
	}

}
