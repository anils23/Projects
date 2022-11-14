package com.tyss.feignclientcontroller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tyss.entity.Superheroes;

@FeignClient(name = "SUPERHERO-SERVICE")
public interface SuperHeroRestController {
	
	@GetMapping("/superhero/{id}")
	public Superheroes getSuperheroById(@PathVariable Integer id);

}
