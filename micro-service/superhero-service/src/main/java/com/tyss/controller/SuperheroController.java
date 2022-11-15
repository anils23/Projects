package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Superheroes;
import com.tyss.response.SuperheroResponse;
import com.tyss.service.SuperheroService;

@RestController
@RequestMapping("/superhero")
public class SuperheroController {

	@Autowired
	private SuperheroService superheroService;

	@GetMapping("/{id}")
	public ResponseEntity<SuperheroResponse> getSuperheroById(@PathVariable Integer id) {
		return ResponseEntity.ok(SuperheroResponse.builder().error(false).message("Here is your Superhero").data(superheroService.getSuperheroById(id)).build());
	}
	
	@GetMapping("/all")
	public ResponseEntity<SuperheroResponse> getAllSuperHeroes() {
		return ResponseEntity.ok(SuperheroResponse.builder().error(false).message("All the Superhero").data(superheroService.getAllSuperHeroes()).build()); 
	}

	@PostMapping("/add")
	public ResponseEntity<SuperheroResponse> addSuperhero(@RequestBody Superheroes superheroes) {
		return ResponseEntity.ok(SuperheroResponse.builder().error(false).message("Superhero added").data(superheroService.addSuperhero(superheroes)).build());
	}

}
