package com.caramelobank.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.PessoaJuridica;
import com.caramelobank.project.repositories.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaRepository repository;
	
	
	
	public List<PessoaJuridica> findAll(){
		return repository.findAll();
	}
	
	
	public PessoaJuridica findById(Long id) {
		Optional<PessoaJuridica> objPessoaJuridica = repository.findById(id);
		return objPessoaJuridica.get();
	}
}
