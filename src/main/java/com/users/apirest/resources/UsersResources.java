package com.users.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.apirest.models.Users;
import com.users.apirest.repository.UsersRepository;

@RestController
@RequestMapping(value="/api")
public class UsersResources {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/users")
	public List<Users> listUsers(){
		return usersRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Users listUser(@PathVariable(value="id") long id){
		return usersRepository.findById(id);
	}
	
	@PostMapping("/user")
	public Users saveUser(@RequestBody Users user){
		return usersRepository.save(user);
	}
	
	@DeleteMapping("/user")
	public void deleteUser(@RequestBody Users user) {
		usersRepository.delete(user);
	}
	
	@PutMapping("/user")
	public Users updateUser(@RequestBody Users user) {
		return usersRepository.save(user);
	}
}
