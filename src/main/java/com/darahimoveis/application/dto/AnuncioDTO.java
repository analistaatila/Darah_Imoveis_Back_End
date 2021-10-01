package com.darahimoveis.application.dto;

import com.darahimoveis.application.model.Anuncio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnuncioDTO {

	private Integer id_anuncio;
	private ImovelDTO imovelDTO;
	private UsuarioDTO usuarioDTO;
	private String tipo_compartilhamento;
	private String detalhes_residencia;
	private String regras_residencia;
	private String detalhes_quarto;
	private String detalhes_regiao;
	private String mapa_embed;
	private String data_publicacao;
	
	
public AnuncioDTO createAnuncioDto(Anuncio anuncio) {
		
	AnuncioDTO anuncioDTO = new AnuncioDTO();
	
	anuncioDTO.setId_anuncio(anuncio.getId_anuncio());
	anuncioDTO.setImovelDTO(new ImovelDTO().createImovelDto(anuncio.getImovel()));
	anuncioDTO.setUsuarioDTO(new UsuarioDTO().createUsuarioDto(anuncio.getUsuario()));
	anuncioDTO.setTipo_compartilhamento(anuncio.getTipo_compartilhamento());
	anuncioDTO.setDetalhes_residencia(anuncio.getDetalhes_residencia());
	anuncioDTO.setRegras_residencia(anuncio.getRegras_residencia());
	anuncioDTO.setDetalhes_regiao(anuncio.getDetalhes_regiao());
	anuncioDTO.setMapa_embed(anuncio.getMapa_embed());
	anuncioDTO.setData_publicacao(anuncio.getData_publicacao());
		
	return anuncioDTO;
	}
}
