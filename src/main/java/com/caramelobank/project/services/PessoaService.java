package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.Pessoa;
import com.caramelobank.project.repositories.PessoaRepository;



@Service
public class PessoaService {
	
	
	@Autowired
	private PessoaRepository repository;
	
	
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> objPessoa = repository.findById(id);
		return objPessoa.get();
		
	}

}
