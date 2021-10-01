package com.darahimoveis.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darahimoveis.application.dto.ImovelDTO;
import com.darahimoveis.application.model.Imovel;
import com.darahimoveis.application.service.ImovelService;

@RestController
@RequestMapping("/imovel")
@CrossOrigin
public class ImovelController {

    @Autowired
	ImovelService imovelService;
    
    /*GetMappings*/
    @GetMapping("/findAll")
	public List<Imovel> findAll(){
		List<Imovel> imoveis = imovelService.findAll();
		return imoveis;
	}
    
    @GetMapping("/findById")
	public Imovel findByID(@RequestParam Integer id) {
    	Optional<Imovel> imovel =  Optional.ofNullable(imovelService.findById(id));
		return imovel.get();
	}
    
    /*PostMappings*/
    @PostMapping
	public ResponseEntity<Integer> salvar(@RequestBody ImovelDTO imovelDTO){
    	Integer id_imovel = imovelService.save(imovelDTO);
    	System.out.println(id_imovel);
		return new ResponseEntity<Integer>(id_imovel,HttpStatus.CREATED);
	}
    
    @PutMapping("/update")
	public ResponseEntity update(@RequestBody Imovel imovel) {
		try {
			imovelService.update(imovel);			
			return new ResponseEntity(HttpStatus.OK);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Não há Imóvel para o código informado");
		}
	}
}
