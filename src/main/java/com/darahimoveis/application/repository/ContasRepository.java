package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Contas;

public interface ContasRepository extends JpaRepository<Contas, Integer>, JpaSpecificationExecutor<Contas>{
	
}
