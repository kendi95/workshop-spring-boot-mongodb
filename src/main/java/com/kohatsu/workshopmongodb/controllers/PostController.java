package com.kohatsu.workshopmongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kohatsu.workshopmongodb.collections.Post;
import com.kohatsu.workshopmongodb.servicies.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	
}
