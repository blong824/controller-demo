package com.billy.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cars")
public class MyFirstController {

	@Autowired
	CarServiceInterface service;
	
	@Autowired
	ObjectMapper mapper;

	/**
	 * 
	 * http://localhost:9999/demo/my/two?id=3
	 * http://localhost:9999/demo/my/two?id=3&test=true
	 * http://localhost:9999/demo/my/2/?id=3
	 * http://localhost:9999/demo/my/  body {}
	 * 
	 * http://localhost:9999/demo/cars//?make={v}&model={model}  GET
	 * http://localhost:9999/demo/cars/{id} GET
	 * 
	 * http://localhost:9999/demo/cars  POST   body {}
	 * 
	 * http://localhost:9999/demo/cars/{id} PATCH  body {}
	 * http://localhost:9999/demo/cars/{id} DELETE 
	 * 
	 */
	

	@GetMapping(value = "/")
	public List<Car> getCarsByMakeAndModel(@RequestParam() String make, @RequestParam String model) {
		return service.getCars(make, model);
	}
	
	@GetMapping(value = "/{id}")
	public Car getCarsByMakeAndModel(@PathVariable() Long id) {
		
		return service.getCarsById(id);
	}
	
	@PostMapping(value ="/")
	public Car addCar(@RequestBody String json) {
		
		System.out.println(json);
		
		try {
			
			JsonNode node = mapper.readTree(json);
			
			String make = node.get("make").asText();
			
			System.out.println(make);
			
			Car c = service.addCar(new Car(make));
			
			return c;
			
		} catch (JsonProcessingException e) {

		}
		
		return null;
	}
	
}
