package com.springbootapp.service;

import org.springframework.stereotype.Service;

import com.springbootapp.model.Planet;

@Service
public class PlanetServiceImpl implements PlanetService {

    private final RestService restService = new RestServiceImpl();

	@Override
	public Planet getPlanetById() {
		String url = "https://swapi.dev/api/planets/1";
		 Planet result = restService.callService(url, Planet.class);
		return result;
	}

}
