package com.darahimoveis.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darahimoveis.application.dto.UsuarioDTO;
import com.darahimoveis.application.model.Usuario;
import com.darahimoveis.application.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	/*GetMappings*/
	@GetMapping("/findById")
	public Usuario findByID(@RequestParam Integer id) {
		Optional<Usuario> usuario =  usuarioService.findById(id);
		return usuario.get();
	}
	
	@GetMapping("/loginSenha")
	public ResponseEntity<Usuario>signin(
										@RequestHeader("email") String email,
										@RequestHeader("senha") String senha){
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		return new ResponseEntity<Usuario>(usuarioService.findByEmailAndSenha(usuario), HttpStatus.OK);
	}
	

	/*PostMappings*/
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody UsuarioDTO usuarioDTO){
		usuarioService.save(usuarioDTO);
		return new ResponseEntity<String>("Usuário Cadastrado!",HttpStatus.CREATED);
	}
	
	
}
