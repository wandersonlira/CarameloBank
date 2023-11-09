package com.caramelobank.project.viacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caramelobank.project.entities.Endereco;

@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepAPI {
	
	
	@GetMapping("{cep}")
	public Endereco consultaCep(@PathVariable("cep") String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Endereco> resp =  restTemplate.getForEntity(
				String.format("https://viacep.com.br/ws/%s/json/", cep), Endereco.class);
		
		return resp.getBody();
	}
	
	
	
	

}
