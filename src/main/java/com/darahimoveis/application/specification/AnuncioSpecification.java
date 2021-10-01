package com.darahimoveis.application.specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darahimoveis.application.model.Anuncio;
import com.darahimoveis.application.model.Foto;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.model.Mapa;
import com.darahimoveis.application.model.Usuario;

public class AnuncioSpecification implements Specification<Anuncio>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7054719806383180015L;
	
	private Integer id_anuncio;
	private Imovel imovel;
	private List<Foto> fotos;
	private Usuario usuario;
	private Mapa mapa_embed;
	private LocalDateTime data_publicacao;

	@Override
	public Predicate toPredicate(Root<Anuncio> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(this.id_anuncio != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("id_anuncio"), id_anuncio);
			predicates.add(predicate);
		}
		
		if(this.imovel != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("imovel"), imovel);
			predicates.add(predicate);
		}
		
		if(this.fotos != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("fotos"), fotos);
			predicates.add(predicate);
		}
		
		if(this.mapa_embed != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("mapa_embed"), mapa_embed);
			predicates.add(predicate);
		}
		if(this.usuario != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("usuario"), usuario);
			predicates.add(predicate);
		}
		
		if(this.data_publicacao != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("data_publicacao"), data_publicacao);
			predicates.add(predicate);
		}
		
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
		return criteriaBuilder.and(arrayPredicates);
	}

	
}
