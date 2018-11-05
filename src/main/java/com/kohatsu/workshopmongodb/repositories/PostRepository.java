package com.kohatsu.workshopmongodb.repositories;

import java.util.Date;
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
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
