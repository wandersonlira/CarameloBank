package com.caramelobank.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caramelobank.project.entities.Pessoa;
import com.caramelobank.project.services.PessoaService;

@RestController
@RequestMapping(value = "/clientes")
public class PessoaResource {
	
	
	@Autowired
	private PessoaService service;
	
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> listPessoa = service.findAll();
		return ResponseEntity.ok().body(listPessoa);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa objPessoa = service.findById(id);
		return ResponseEntity.ok().body(objPessoa);
	}
	

}
