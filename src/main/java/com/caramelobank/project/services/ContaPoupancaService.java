package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.ContaPoupanca;
import com.caramelobank.project.repositories.ContaPoupancaRepository;

@Service
public class ContaPoupancaService {
	
	@Autowired
	ContaPoupancaRepository repository;
	
	
	public List<ContaPoupanca> findAll() {
		return repository.findAll();
	}
	
	
	
	public ContaPoupanca findById(Long id) {
		Optional<ContaPoupanca> objContaPoupanca = repository.findById(id);
		return objContaPoupanca.get();
	}

}
