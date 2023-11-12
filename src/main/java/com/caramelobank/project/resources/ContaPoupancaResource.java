package com.caramelobank.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caramelobank.project.entities.ContaPoupanca;
import com.caramelobank.project.services.ContaPoupancaService;

@RestController
@RequestMapping(value = "/poupancas")
public class ContaPoupancaResource {
	
	
	@Autowired
	ContaPoupancaService service;
	
	
	@GetMapping
	public ResponseEntity<List<ContaPoupanca>> findAll() {
		List<ContaPoupanca> listContaPoupanca = service.findAll();
		return ResponseEntity.ok().body(listContaPoupanca);
	}

	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaPoupanca> findById(@PathVariable Long id) {
		ContaPoupanca objContaPoupanca = service.findById(id);
		return ResponseEntity.ok().body(objContaPoupanca);
	}
}
