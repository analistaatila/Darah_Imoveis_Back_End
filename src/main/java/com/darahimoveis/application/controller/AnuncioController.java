package com.darahimoveis.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darahimoveis.application.dto.AnuncioDTO;
import com.darahimoveis.application.model.Anuncio;
import com.darahimoveis.application.service.AnuncioService;

@RestController
@RequestMapping("/anuncio")
@CrossOrigin
public class AnuncioController {
	
	@Autowired
	AnuncioService anuncioService;
	
	@GetMapping("/findAll")
	public List<Anuncio> findAll(){
		List<Anuncio> anuncios = anuncioService.findAll();
		return anuncios;
	}
	
	@PostMapping
	public ResponseEntity<Integer> salvarAnuncio(@RequestBody AnuncioDTO anuncioDTO){
		Integer id_anuncio = anuncioService.save(anuncioDTO);
		return new ResponseEntity<Integer>(id_anuncio,HttpStatus.CREATED);

	}
	
	@GetMapping("/findById")
	public Anuncio findByID(@RequestParam Integer id) {
    	Optional<Anuncio> anuncio =  Optional.ofNullable(anuncioService.findById(id));
		return anuncio.get();
	}
}
