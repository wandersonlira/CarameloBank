package com.caramelobank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caramelobank.project.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	

}
