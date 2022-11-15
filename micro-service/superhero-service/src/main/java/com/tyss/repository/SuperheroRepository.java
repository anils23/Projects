package com.tyss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Superheroes;

public interface SuperheroRepository extends JpaRepository<Superheroes, Integer>{

}
