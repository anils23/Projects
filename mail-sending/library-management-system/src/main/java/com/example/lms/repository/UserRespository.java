package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.entity.Users;

public interface UserRespository extends JpaRepository<Users, Integer>{

}
