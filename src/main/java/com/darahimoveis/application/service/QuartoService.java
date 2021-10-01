package com.darahimoveis.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darahimoveis.application.dto.QuartoDTO;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.model.Quarto;
import com.darahimoveis.application.repository.QuartoRepository;

@Service
public class QuartoService {
	@Autowired
	QuartoRepository quartoRepository;
	@Autowired
	ImovelService imovelService;
	
	public void save(QuartoDTO quartoDTO){
		Quarto quarto = new Quarto();
		Imovel imovel = imovelService.findById(quartoDTO.getId_imovel());
		
		if(quartoDTO.getTipo_quarto() != null) {
			quarto.setId_quarto(quartoDTO.getId_quarto());
			quarto.setTipo_quarto(quartoDTO.getTipo_quarto());
			quarto.setMetragem_quarto(quartoDTO. getMetragem_quarto());
			imovel.setQuarto(quarto);
			quartoRepository.save(quarto);
		}else {
			System.out.println("Deu Algum erro no service");
		}
		
		try {
			imovelService.update(imovel);
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		
	}
	
	public List<Quarto> findAll(){
		List<Quarto> quarto = quartoRepository.findAll();
		return quarto;
	}
	
	public Optional<Quarto> findById(Integer id_quarto) {
		Optional<Quarto> quarto = quartoRepository.findById(id_quarto);
		return quarto;
	}
}
