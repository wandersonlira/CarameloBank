package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.Conta;
import com.caramelobank.project.repositories.ContaRepository;

@Service
public class ContaService {

	
	@Autowired
	private ContaRepository repository;
	
	
	public List<Conta> findAll() {
		return repository.findAll();
	}
	
	
	
	public Conta findById(Long id) {
		Optional<Conta> objConta = repository.findById(id);
		return objConta.get();
	}
}
