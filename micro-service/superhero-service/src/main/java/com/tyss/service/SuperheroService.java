package com.tyss.service;

import java.util.List;

import com.tyss.entity.Superheroes;

public interface SuperheroService {
	
	Superheroes getSuperheroById(Integer id);
	
	List<Superheroes> getAllSuperHeroes();
	
	Superheroes addSuperhero(Superheroes superheroes);
	
}
