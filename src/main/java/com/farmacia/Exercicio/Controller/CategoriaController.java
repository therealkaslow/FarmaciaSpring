package com.farmacia.Exercicio.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.Exercicio.Model.CategoriaModel;
import com.farmacia.Exercicio.Repository.CategoriaRepository;

@RestController	
@RequestMapping("/api/v1/categoria")
@CrossOrigin("*")

public class CategoriaController {

	private @Autowired CategoriaRepository repositorio;

	@GetMapping("/todes")
	public ResponseEntity<List<CategoriaModel>> getAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
	        return ResponseEntity.status(200).body(repositorio.findAll());
	       
		}
	}
	
	 @PostMapping("/salvar")
	    public ResponseEntity<CategoriaModel> salvar(@Valid @RequestBody CategoriaModel novaCategoria) {
	        return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	 }
	

	
}
