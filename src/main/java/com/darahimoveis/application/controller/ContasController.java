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

import com.darahimoveis.application.dto.ContasDTO;
import com.darahimoveis.application.model.Contas;
import com.darahimoveis.application.service.ContasService;

@RestController
@RequestMapping("/contas")
@CrossOrigin
public class ContasController {

	@Autowired
	ContasService contasService;
	
	/*GetMappings*/
	@GetMapping("/findById")
	public Contas findByID(@RequestParam Integer id) {
		Optional<Contas> contas =  contasService.findById(id);
		return contas.get();
	}
	
	@GetMapping("/findAll")
	public List<Contas> findAll() {
		List<Contas> contas = contasService.findAll();
		return contas;
	}
	
	@PostMapping
	public ResponseEntity<String> salvarContas(@RequestBody ContasDTO contasDTO){
		contasService.save(contasDTO);
		return new ResponseEntity<String>("Contas Cadastrado!",HttpStatus.CREATED);
	}
}
