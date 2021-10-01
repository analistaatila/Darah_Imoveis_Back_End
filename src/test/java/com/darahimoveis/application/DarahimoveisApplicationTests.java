package com.darahimoveis.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.darahimoveis.application.model.Usuario;
import com.darahimoveis.application.service.UsuarioService;

@SpringBootTest
class DarahimoveisApplicationTests {

	@MockBean
	UsuarioService usuarioService;
	
	//H2
	
	@BeforeEach
	void setup() {
		Optional<Usuario> usuario = Optional.of(new Usuario(2,"Duan","Camargo","71999996666","duan@duan.com", "12345", "2021-08-01 12:00:00"));
		when(usuarioService.findById(2)).thenReturn(usuario);
	}
	
	@Test
	void findByID(){
		assertEquals(usuarioService.findById(2).get().getNome(), "Duan");
	}
}