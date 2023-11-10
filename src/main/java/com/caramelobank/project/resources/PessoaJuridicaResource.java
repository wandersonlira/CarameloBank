package com.caramelobank.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caramelobank.project.entities.PessoaJuridica;
import com.caramelobank.project.services.PessoaJuridicaService;

@RestController
@RequestMapping(value = "/juridicas")
public class PessoaJuridicaResource {
	
	@Autowired
	PessoaJuridicaService service;
	
	
	@GetMapping
	public ResponseEntity<List<PessoaJuridica>> findAll() {
		List<PessoaJuridica> listPessoaJuridica = service.findAll();
		return ResponseEntity.ok().body(listPessoaJuridica);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaJuridica> findById(@PathVariable Long id) {
		PessoaJuridica objPessoaJuridica = service.findById(id);
		return ResponseEntity.ok().body(objPessoaJuridica);
	}

}
