package com.darahimoveis.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darahimoveis.application.model.Quarto;

public class QuartoSpecification implements Specification<Quarto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421980597838163608L;

	private String tipo_quarto;
	private String descricao_quarto;
	private Integer qtd_cama;
	private Double metragem_quarto;

	
	
	@Override
	public Predicate toPredicate(Root<Quarto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(this.tipo_quarto != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("tipo_quarto"), tipo_quarto);
			predicates.add(predicate);
		}
		if(this.descricao_quarto != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("descricao_quarto"), descricao_quarto);
			predicates.add(predicate);
		}
		if(this.qtd_cama != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("qtd_cama"), qtd_cama);
			predicates.add(predicate);
		}
		if(this.metragem_quarto != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("metragem_quarto"), metragem_quarto);
			predicates.add(predicate);
		}
		
		return null;
	}

}
