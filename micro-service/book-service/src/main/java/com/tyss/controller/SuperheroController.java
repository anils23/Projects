package com.tyss.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Superheroes;

@RestController
@RequestMapping("/superhero")
public class SuperheroController {
	
		List<Superheroes> list = List.of(new Superheroes(101,"Iron man","Tony stark"),
				new Superheroes(102,"Captain America","Steve rogers"),
				new Superheroes(103,"Thor","Thor odinson"));
		
		@GetMapping("/{id}")
		public Superheroes getSuperheroById(@PathVariable Integer id) {
			return list.stream().filter(t -> t.getId().equals(id)).toList().get(0);
		}
		
		@GetMapping("/all")
		public List<Superheroes> getAllSuperHeroes(){
			return list;
		}
		
		


}
