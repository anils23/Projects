package com.te.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.resumebuilder.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUsername(String username);

}
