package com.thales.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thales.course.entities.User;
import com.thales.course.services.UserService;

//Indica para o spring que isso é um recurso e implementado por um controlador rest
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//Injeção de dependencia
	@Autowired
	private UserService service;
	
	//Indica uma requisição do tipo GET do HTTP
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
