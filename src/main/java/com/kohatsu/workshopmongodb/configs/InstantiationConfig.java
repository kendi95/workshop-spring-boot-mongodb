package com.kohatsu.workshopmongodb.configs;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kohatsu.workshopmongodb.collections.Post;
import com.kohatsu.workshopmongodb.collections.User;
import com.kohatsu.workshopmongodb.repositories.PostRepository;
import com.kohatsu.workshopmongodb.repositories.UserRepository;

@Configuration
public class InstantiationConfig implements CommandLineRunner{

	@Autowired
	private UserRepository repo;
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "bom dia", "Acordei feliz hoje!", maria);
		
		repo.saveAll(Arrays.asList(maria, alex, bob));
		postRepo.saveAll(Arrays.asList(post1, post2));
		
	}

}
