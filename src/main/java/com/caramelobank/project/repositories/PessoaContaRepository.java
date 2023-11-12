package com.caramelobank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caramelobank.project.entities.PessoaConta;

public interface PessoaContaRepository extends JpaRepository<PessoaConta, Long>{

}
