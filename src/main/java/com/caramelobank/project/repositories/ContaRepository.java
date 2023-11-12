package com.caramelobank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caramelobank.project.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
