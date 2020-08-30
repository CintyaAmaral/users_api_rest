package com.users.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.apirest.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findById(long id);
}
