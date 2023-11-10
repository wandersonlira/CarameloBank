package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.ContaCorrente;
import com.caramelobank.project.repositories.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	
	@Autowired
	ContaCorrenteRepository repository;
	
	
	
	public List<ContaCorrente> findAll() {
		return repository.findAll();
	}
	
	
	public ContaCorrente findById(Long id) {
		Optional<ContaCorrente> objContaCorrente = repository.findById(id);
		return objContaCorrente.get();
	}

}
