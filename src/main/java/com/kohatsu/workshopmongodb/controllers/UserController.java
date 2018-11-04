package com.kohatsu.workshopmongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kohatsu.workshopmongodb.entities.User;
import com.kohatsu.workshopmongodb.servicies.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
}
