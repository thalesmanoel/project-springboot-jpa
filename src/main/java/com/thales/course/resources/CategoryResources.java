package com.thales.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thales.course.entities.Category;
import com.thales.course.services.CategoryService;

//Indica para o spring que isso é um recurso e implementado por um controlador rest
@RestController
@RequestMapping(value="/categories")
public class CategoryResources {
	
	//Injeção de dependencia
	@Autowired
	private CategoryService service;
	
	//Indica uma requisição do tipo GET do HTTP
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
