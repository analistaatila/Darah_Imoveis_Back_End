package com.darahimoveis.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "conta")
public class Contas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
    private Integer id_conta;
	
//	@OneToOne
//	@JoinColumn(name="id_imovel")
//	private Imovel imovel;
	
	@Column
	private Double aluguel;
	
	@Column
	private Double iptu;
	
	@Column
	private Double condominio;
	
	@Column
	private Double internet;

	@Column
	private Double tv_cabo;
	
	@Column
	private Double agua;
	
	@Column
	private Double energia;
	
	@Column
	private Double gas;
}
