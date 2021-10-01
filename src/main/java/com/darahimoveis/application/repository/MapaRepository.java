package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Mapa;

public interface MapaRepository extends JpaRepository<Mapa, Integer>, JpaSpecificationExecutor<Mapa>{

}
