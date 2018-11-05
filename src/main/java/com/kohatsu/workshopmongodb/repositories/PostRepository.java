package com.kohatsu.workshopmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kohatsu.workshopmongodb.collections.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//query personalizado
	//o ?0 é o primeiro parametro 'text'
	/*@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);*/
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
