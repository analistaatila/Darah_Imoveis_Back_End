package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>, JpaSpecificationExecutor<Anuncio>{

}
