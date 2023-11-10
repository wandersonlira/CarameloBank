package com.caramelobank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caramelobank.project.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	

}
