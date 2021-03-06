package com.kohatsu.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kohatsu.workshopmongodb.collections.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
