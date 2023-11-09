package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.Endereco;
import com.caramelobank.project.repositories.EnderecoRepository;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	
	public Endereco findById(Long id) {
		Optional<Endereco> objEndereco = repository.findById(id);
		return objEndereco.get();
	}

}
