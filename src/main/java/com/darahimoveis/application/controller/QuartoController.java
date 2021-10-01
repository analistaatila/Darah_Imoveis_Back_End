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

import com.darahimoveis.application.dto.QuartoDTO;
import com.darahimoveis.application.model.Quarto;
import com.darahimoveis.application.service.QuartoService;

@RestController
@RequestMapping("/quarto")
@CrossOrigin
public class QuartoController {
	
	@Autowired
	QuartoService quartoService;
	
	
	@GetMapping("/findById")
	public Optional<Quarto> findByID(@RequestParam Integer id_quarto) {
		Optional<Quarto> quarto =  quartoService.findById(id_quarto);
		return quarto;
	}
	
	@GetMapping("/findAll")
	public List<Quarto> findAll() {
		List<Quarto> quarto = quartoService.findAll();
		return quarto;
	}
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody QuartoDTO quartoDTO){
		quartoService.save(quartoDTO);
		return new ResponseEntity<String>("Quarto Cadastrado!",HttpStatus.CREATED);
	}
}
