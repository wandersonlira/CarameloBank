package com.caramelobank.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caramelobank.project.entities.Conta;
import com.caramelobank.project.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> listConta = service.findAll();
		return ResponseEntity.ok().body(listConta);
	}
	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta objConta = service.findById(id);
		return ResponseEntity.ok().body(objConta);
	}

}
