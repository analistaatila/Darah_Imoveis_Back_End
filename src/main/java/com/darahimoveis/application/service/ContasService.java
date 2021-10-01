package com.darahimoveis.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darahimoveis.application.dto.AnuncioDTO;
import com.darahimoveis.application.dto.ContasDTO;
import com.darahimoveis.application.model.Anuncio;
import com.darahimoveis.application.model.Contas;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.model.Usuario;
import com.darahimoveis.application.repository.ContasRepository;

@Service
public class ContasService {
	
	@Autowired
	ContasRepository contasRepository;
	@Autowired
	ImovelService imovelService;
	
	public Optional<Contas> findById(Integer id) {
		Optional<Contas> contas = contasRepository.findById(id);
		return contas;
	}
	
	public Integer save(ContasDTO contasDTO){
		Contas contas = new Contas();
		Contas contasRetorno = new Contas();
		Imovel imovel = imovelService.findById(contasDTO.getId_imovel());

		if(contasDTO.getAluguel() != null){	
			contas.setAluguel(contasDTO.getAluguel());
			contas.setIptu(contasDTO. getIptu());
			contas.setCondominio(contasDTO.getCondominio());
			contas.setInternet(contasDTO.getInternet());
			contas.setTv_cabo(contasDTO.getTv_cabo());
			contas.setAgua(contasDTO.getAgua());
			contas.setEnergia(contasDTO.getEnergia());
			contas.setGas(contasDTO.getGas());
			imovel.setConta(contas);
			contasRepository.save(contas);
		}else {
			System.out.println("Deu Algum erro no service de contas!");
		}
		
		try {
			imovelService.update(imovel);
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		return contasRetorno.getId_conta();
	}
	
    
	public List<Contas> findAll(){
		List<Contas> contas = contasRepository.findAll();
		return contas;
	}
}
