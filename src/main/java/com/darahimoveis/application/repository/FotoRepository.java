package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, String>, JpaSpecificationExecutor<Foto>{

}
