package com.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.model.Planet;
import com.springbootapp.service.PlanetService;

@RestController
public class PlanetController {
	
	@Autowired
	PlanetService planetService;
	
	@GetMapping(value= "/planets")
	public ResponseEntity<Planet> getPlanets(){
	     Planet planet = planetService.getPlanetById();
	     System.out.println(planet.name);
	     return ResponseEntity.ok(planet);
	}
}
