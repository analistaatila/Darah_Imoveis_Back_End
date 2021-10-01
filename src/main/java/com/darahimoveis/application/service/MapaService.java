package com.darahimoveis.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darahimoveis.application.model.Mapa;
import com.darahimoveis.application.repository.MapaRepository;

@Service
public class MapaService {

	@Autowired
	MapaRepository mapaRepository;
	
	public Optional<Mapa> findById(Integer id) {
		Optional<Mapa> mapa = mapaRepository.findById(id);
		return mapa;
	}
}
