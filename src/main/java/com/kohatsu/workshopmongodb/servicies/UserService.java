package com.kohatsu.workshopmongodb.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kohatsu.workshopmongodb.dto.UserDTO;
import com.kohatsu.workshopmongodb.entities.User;
import com.kohatsu.workshopmongodb.repositories.UserRepository;
import com.kohatsu.workshopmongodb.servicies.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public User insert(UserDTO userDTO) {
		return repo.insert(new User(userDTO));
	}
	
	public void deleteById(String id) {
		User user = this.findById(id);		
		repo.deleteById(user.getId());
	}
	
	public User update(String id, UserDTO userDTO) {
		User user = this.findById(id);
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		return repo.save(user);
	}
	
}
