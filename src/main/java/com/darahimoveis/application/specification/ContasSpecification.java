package com.darahimoveis.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darahimoveis.application.model.Contas;

public class ContasSpecification implements Specification<Contas>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8344340164780959906L;
	
	private String descricao;
	
	@Override
	public Predicate toPredicate(Root<Contas> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(this.descricao != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("descricao"), descricao);
			predicates.add(predicate);
		}
		
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
		return criteriaBuilder.and(arrayPredicates);
	}
}
