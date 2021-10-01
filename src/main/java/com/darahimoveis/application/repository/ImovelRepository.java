package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.darahimoveis.application.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> , JpaSpecificationExecutor<Imovel>{
    
}
