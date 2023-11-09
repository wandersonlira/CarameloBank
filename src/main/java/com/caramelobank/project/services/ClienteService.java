package com.caramelobank.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caramelobank.project.entities.Cliente;
import com.caramelobank.project.repositories.ClienteRepository;



@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository repository;
	
	
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}

}
