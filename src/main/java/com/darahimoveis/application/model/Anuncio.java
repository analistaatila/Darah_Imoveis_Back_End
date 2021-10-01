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
@Entity(name = "anuncio")
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_anuncio")
    private Integer id_anuncio;
	
	@OneToOne
	@JoinColumn(name="id_imovel")
	private Imovel imovel;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column
	private String tipo_compartilhamento;
	
	@Column
	private String detalhes_residencia;
	
	@Column
	private String regras_residencia;
	
	@Column
	private String detalhes_quarto;
	
	@Column
	private String detalhes_regiao;
	
	@Column
	private String mapa_embed;
	
	@Column
	private String data_publicacao;
}