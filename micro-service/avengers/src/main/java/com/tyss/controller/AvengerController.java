package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Superheroes;
import com.tyss.feignclientcontroller.SuperHeroRestController;
import com.tyss.response.MyResponse;

@RestController
@RequestMapping("/avenger")
public class AvengerController {
	
	@Autowired
	private SuperHeroRestController controller;

	@GetMapping("/{id}")
	public MyResponse getSuperherodata(@PathVariable Integer id) {
		Superheroes superheroes = controller.getSuperheroById(id);
		return MyResponse.builder().message("called from avengers").data(superheroes).build();
	}
	
}
