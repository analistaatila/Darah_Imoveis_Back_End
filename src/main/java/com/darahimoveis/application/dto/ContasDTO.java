package com.darahimoveis.application.dto;

import com.darahimoveis.application.model.Contas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasDTO {

	private Integer id_imovel;
	private Integer id_contas;
//	private ImovelDTO imovelDTO;
	private Double aluguel;
	private Double iptu;
	private Double condominio;
	private Double internet;
	private Double tv_cabo;
	private Double agua;
	private Double energia;
	private Double gas;
	
public ContasDTO createContasDto(Contas conta) {
		
	ContasDTO contasDTO = new ContasDTO();
		
	contasDTO.setId_contas(conta.getId_conta());
//	contasDTO.setImovelDTO(new ImovelDTO().createImovelDto(contas.getImovel()));
	contasDTO.setAluguel(conta.getAluguel());
	contasDTO.setIptu(conta.getIptu());
	contasDTO.setCondominio(conta.getCondominio());
	contasDTO.setInternet(conta.getInternet());
	contasDTO.setTv_cabo(conta.getTv_cabo());
	contasDTO.setAgua(conta.getAgua());
	contasDTO.setEnergia(conta.getEnergia());
	contasDTO.setGas(conta.getGas());
		
	return contasDTO;
	}
}
