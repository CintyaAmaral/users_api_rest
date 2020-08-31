package com.users.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Users API REST")
@CrossOrigin(origins="*")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/users")
	@ApiOperation(value="Retorna uma lista de usuários.")
	public List<Users> listUsers(){
		return usersRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value="Retorna dados de um único usuário.")
	public Users listSingleUser(@PathVariable(value="id") long id){
		return usersRepository.findById(id);
	}
	
	@PostMapping("/user")
	@ApiOperation(value="Adiciona um usuário.")
	public Users saveUser(@RequestBody Users user){
		return usersRepository.save(user);
	}
	
	@DeleteMapping("/user")
	@ApiOperation(value="Deleta um usuário.")
	public void deleteUser(@RequestBody Users user) {
		usersRepository.delete(user);
	}
	
	@PutMapping("/user")
	@ApiOperation(value="Atualiza dados de um usuário.")
	public Users updateUser(@RequestBody Users user) {
		return usersRepository.save(user);
	}
}
