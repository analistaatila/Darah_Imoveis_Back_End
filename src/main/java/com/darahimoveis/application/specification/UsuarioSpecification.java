package com.darahimoveis.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darahimoveis.application.model.Usuario;

public class UsuarioSpecification implements Specification<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6127956662890283800L;
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String whatsapp;
	private String email;
	private String senha;


	public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(this.id != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("id_usuario"), id);
			predicates.add(predicate);
		}
		if(this.nome != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("nome"), nome);
			predicates.add(predicate);
		}
		if(this.sobrenome != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("sobrenome"), sobrenome);
			predicates.add(predicate);
		}
		if(this.whatsapp != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("whatsapp"), whatsapp);
			predicates.add(predicate);
		}
		if(this.email != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("email"), email);
			predicates.add(predicate);
		}
		if(this.senha != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("senha"), senha);
			predicates.add(predicate);
		}
		
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
		
		return criteriaBuilder.and(arrayPredicates);
	}

}
