package com.darahimoveis.application.dto;

import com.darahimoveis.application.model.Foto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FotoDTO {
	
	private Integer id_foto;
	private String descricao_foto;
	private Byte[] fotoByte;
	private ImovelDTO imovelDTO;
	
	
	public FotoDTO createFotoDto(Foto foto) {	
		FotoDTO fotoDTO = new FotoDTO();
		
		fotoDTO.setId_foto(foto.getId_foto());
		fotoDTO.setDescricao_foto(foto.getDescricao_foto());
		fotoDTO.setFotoByte(foto.getFoto());
		fotoDTO.setImovelDTO(new ImovelDTO().createImovelDto(foto.getImovel()));
		
		return fotoDTO;
	}
}
