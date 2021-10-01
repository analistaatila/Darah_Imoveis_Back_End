package com.darahimoveis.application.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.darahimoveis.application.model.Foto;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.repository.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	FotoRepository fotoRepository;
	@Autowired
	ImovelService imovelService;
	
	public Integer save( Integer id_imovel, MultipartFile fotos, String descricao_foto){	
		Foto foto = new Foto();
		Foto fotoRetorno = new Foto();
		Imovel imovel = new Imovel();
		
		
		if(id_imovel != 0) {
			imovel = imovelService.findById(id_imovel);
			foto.setImovel(imovel);
			foto.setDescricao_foto(descricao_foto);
			
			Byte[] byteObjects;
			try {
				byteObjects = new Byte[fotos.getBytes().length];
				int i = 0;
				for (byte b : fotos.getBytes()) {
					byteObjects[i++] = b;
				}
				foto.setFoto(byteObjects);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			fotoRetorno = fotoRepository.save(foto);
		}
		
		return fotoRetorno.getId_foto();	
	}
	
	// criar um get findAll
	public List<Foto> findAll(){
		List<Foto> fotos = fotoRepository.findAll();
		return fotos;
	}
}
