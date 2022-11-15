package com.tyss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.entity.Superheroes;
import com.tyss.repository.SuperheroRepository;

@Service
public class SuperheorServiceimpl implements SuperheroService {
	
	@Autowired
	private SuperheroRepository superheroRepository;

	@Override
	public Superheroes getSuperheroById(Integer id) {
		return superheroRepository.findById(id).get();
	}

	@Override
	public List<Superheroes> getAllSuperHeroes() {
		return superheroRepository.findAll();
	}

	@Override
	public Superheroes addSuperhero(Superheroes superheroes) {
		return superheroRepository.save(superheroes);
	}

}
