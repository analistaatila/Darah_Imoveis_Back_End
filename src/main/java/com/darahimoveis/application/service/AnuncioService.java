package com.darahimoveis.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.darahimoveis.application.dto.AnuncioDTO;
import com.darahimoveis.application.model.Anuncio;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.model.Usuario;
import com.darahimoveis.application.repository.AnuncioRepository;

@Service
public class AnuncioService {
	
	@Autowired
	AnuncioRepository anuncioRepository;
	
	public List<Anuncio> findAll(){
		List<Anuncio> anuncios = anuncioRepository.findAll();
		return anuncios;
	}
	
	//Método que irá consultar o repository que estende o JPA
	public Page<Anuncio> findAll(Integer pagina, Integer linhasPorPagina, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Sort.Direction.valueOf(direction), orderBy);
		
		return anuncioRepository.findAll(pageRequest);
	}
	
	public Anuncio findById(Integer id) {
		return anuncioRepository.findById(id).get();
	}
	
	public Integer save(AnuncioDTO anuncioDTO){
		Anuncio anuncio = new Anuncio();
		Anuncio anuncioRetorno = new Anuncio();
		Usuario usuario = new Usuario();
		
		if(anuncioDTO.getData_publicacao() != null){
			Imovel imovel = new Imovel();
			
			imovel.setId_imovel(anuncioDTO.getImovelDTO().getId_imovel());
			anuncio.setImovel(imovel);
			usuario.setId_usuario(anuncioDTO.getUsuarioDTO().getId_usuario());
			anuncio.setUsuario(usuario);
			anuncio.setTipo_compartilhamento(anuncioDTO.getTipo_compartilhamento());
			anuncio.setDetalhes_residencia(anuncioDTO.getDetalhes_residencia());
			anuncio.setRegras_residencia(anuncioDTO.getRegras_residencia());
			anuncio.setDetalhes_regiao(anuncioDTO.getDetalhes_regiao());
			anuncio.setMapa_embed(anuncioDTO.getMapa_embed());
			anuncio.setData_publicacao(anuncioDTO.getData_publicacao());
			anuncio.setDetalhes_quarto(anuncioDTO.getDetalhes_quarto());
			anuncioRetorno = anuncioRepository.save(anuncio);
			anuncioRepository.save(anuncio);
		}else {
			System.out.println("Data vazia");
		}
		
		return anuncioRetorno.getId_anuncio();
	}
}
