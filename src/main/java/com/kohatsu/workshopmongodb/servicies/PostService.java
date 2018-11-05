package com.kohatsu.workshopmongodb.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kohatsu.workshopmongodb.collections.Post;
import com.kohatsu.workshopmongodb.repositories.PostRepository;
import com.kohatsu.workshopmongodb.servicies.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
		/*return repo.searchTitle(text);*/
	}
	
	
}
