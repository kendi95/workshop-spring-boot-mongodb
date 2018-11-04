package com.kohatsu.workshopmongodb.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kohatsu.workshopmongodb.entities.User;
import com.kohatsu.workshopmongodb.repositories.UserRepository;

@Configuration
public class InstantiationConfig implements CommandLineRunner{

	@Autowired
	private UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob grey", "bob@gmail.com");
		
		repo.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
