package com.kohatsu.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kohatsu.workshopmongodb.collections.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
