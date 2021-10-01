package com.darahimoveis.application.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.darahimoveis.application.model.Imovel;

public class ImovelSpecification implements Specification<Imovel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7933231654541090894L;

	private Integer cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String tipo_imovel;
	private String tipo_compartilhamento;
	private Integer qtd_banheiro;
	private Double metragem_imovel;
	private Integer qtd_num_pessoas;
	
	@Override
	public Predicate toPredicate(Root<Imovel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		if(this.cep != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("cep"), cep);
			predicates.add(predicate);
		}
		if(this.logradouro != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("logradouro"), logradouro);
			predicates.add(predicate);
		}
		if(this.bairro != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("bairro"), bairro);
			predicates.add(predicate);
		}
		if(this.cidade != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("cidade"), cidade);
			predicates.add(predicate);
		}
		if(this.estado != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("estado"), estado);
			predicates.add(predicate);
		}
		if(this.tipo_imovel != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("tipo_imovel"), tipo_imovel);
			predicates.add(predicate);
		}
		if(this.tipo_compartilhamento != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("tipo_compartilhamento"), tipo_compartilhamento);
			predicates.add(predicate);
		}
		if(this.qtd_banheiro != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("qtd_banheiro"), qtd_banheiro);
			predicates.add(predicate);
		}
		if(this.metragem_imovel != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("metragem_imovel"), metragem_imovel);
			predicates.add(predicate);
		}
		if(this.qtd_num_pessoas != null) {			
			Predicate predicate = criteriaBuilder.equal(root.get("qtd_num_pessoas"), qtd_num_pessoas);
			predicates.add(predicate);
		}
		
		Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
		return criteriaBuilder.and(arrayPredicates);
	}

}
