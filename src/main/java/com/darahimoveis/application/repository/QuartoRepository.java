package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Integer>, JpaSpecificationExecutor<Quarto> {

}
