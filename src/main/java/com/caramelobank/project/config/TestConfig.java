package com.caramelobank.project.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caramelobank.project.entities.Endereco;
import com.caramelobank.project.entities.Pessoa;
import com.caramelobank.project.repositories.EnderecoRepository;
import com.caramelobank.project.repositories.PessoaRepository;
import com.caramelobank.project.viacep.ConsultaCepAPI;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		Endereco endereco3 = new Endereco();
		
		ConsultaCepAPI api = new ConsultaCepAPI();
		
		endereco1 = api.consultaCep("50630160");
		endereco2 = api.consultaCep("54400020");
		endereco3 = api.consultaCep("50670901");
		
		
		
		Pessoa pessoa1 = new Pessoa(null, "Elon Musk", "00000000001", "bilionario@musk.com", "Ser Bilionário",
				LocalDate.parse("1982-04-15"), endereco1);
		
		Pessoa pessoa2 = new Pessoa(null, "Lenin", "00000000002", "uniao@lenin.com", "Comunista",
				LocalDate.parse("1911-10-20"), endereco2);
		
		Pessoa pessoa3 = new Pessoa(null, "Madona", "00000000003", "cantora@madona.com", "Cantora",
				LocalDate.parse("1979-02-11"), endereco3);

		
		
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3));
		
		System.out.println("PRONTO!!");
		
		
		
	}

}
