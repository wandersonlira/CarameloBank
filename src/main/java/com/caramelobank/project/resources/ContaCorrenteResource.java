package com.caramelobank.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caramelobank.project.entities.ContaCorrente;
import com.caramelobank.project.services.ContaCorrenteService;

@RestController
@RequestMapping(value = "/correntes")
public class ContaCorrenteResource {
	
	@Autowired
	ContaCorrenteService service;
	
	
	@GetMapping
	public ResponseEntity<List<ContaCorrente>> findAll() {
		List<ContaCorrente> listContaCorrente = service.findAll();
		return ResponseEntity.ok().body(listContaCorrente);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaCorrente> findById(@PathVariable Long id) {
		ContaCorrente objContaCorrente = service.findById(id);
		return ResponseEntity.ok().body(objContaCorrente);
	}

}
