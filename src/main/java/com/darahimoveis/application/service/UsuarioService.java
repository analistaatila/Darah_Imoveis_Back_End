package com.darahimoveis.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darahimoveis.application.dto.UsuarioDTO;
import com.darahimoveis.application.model.Usuario;
import com.darahimoveis.application.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Integer save(UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		Usuario usuarioRetorno = new Usuario();
		
		if(usuarioDTO.getNome() != null && usuarioDTO.getSobrenome() != null && usuarioDTO.getEmail() != null && usuarioDTO.getSenha() != null){	
			usuario.setNome(usuarioDTO.getNome());
			usuario.setSobrenome(usuarioDTO.getSobrenome());
			usuario.setWhatsapp(usuarioDTO.getWhatsapp());
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setSenha(usuarioDTO.getSenha());
			usuarioRetorno = usuarioRepository.save(usuario);
		}
		
		return usuarioRetorno.getId_usuario();
	}
	
	public Optional<Usuario> findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	public Usuario findByEmailAndSenha(Usuario usuario) {
		return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha()).get();
	}
}