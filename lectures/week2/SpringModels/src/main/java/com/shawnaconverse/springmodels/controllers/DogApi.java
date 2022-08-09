package com.shawnaconverse.springmodels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shawnaconverse.springmodels.models.Dog;
import com.shawnaconverse.springmodels.services.DogService;

@RestController
public class DogApi {
	private final DogService dogServ;
	
	public DogApi(DogService ds) {
		this.dogServ = ds;
	}
	
	// RESTful Routing Style
	// all routes, in general, take  certain structure
	// /<table_name>/action
	// /api/<table_name>/action
	
	@GetMapping("/api/dogs")
	public List<Dog> getAllDogs() {
		return dogServ.getAll();
	}
	
	
	@PostMapping("/api/dogs/create")
	public Dog createDog(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age,
			@RequestParam(value = "hairColor") String hairColor
			) {
		Dog newDog = new Dog(name, age, hairColor);
		
		return dogServ.save(newDog);
	}
	
}
