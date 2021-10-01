package com.darahimoveis.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darahimoveis.application.model.Mapa;
import com.darahimoveis.application.service.MapaService;

@RestController
@RequestMapping("/mapa")
@CrossOrigin
public class MapaController {

	@Autowired
	MapaService mapaService;
	
	/*GetMappings*/
	@GetMapping("/findById")
	public Mapa findByID(@RequestParam Integer id) {
		Optional<Mapa> mapa =  mapaService.findById(id);
		return mapa.get();
	}
}
