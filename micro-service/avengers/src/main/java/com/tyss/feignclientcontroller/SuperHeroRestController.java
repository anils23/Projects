package com.tyss.feignclientcontroller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.entity.Superheroes;
import com.tyss.feignclientresponse.SuperheroResponse;

@FeignClient(name = "SUPERHERO-SERVICE")
public interface SuperHeroRestController {

	@GetMapping("/superhero/{id}")
	ResponseEntity<SuperheroResponse> getSuperheroById(@PathVariable Integer id);
	
	@PostMapping("/superhero/add")
	ResponseEntity<SuperheroResponse> addSuperhero(@RequestBody Superheroes superheroes);
}
