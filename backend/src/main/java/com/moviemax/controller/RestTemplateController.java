package com.moviemax.controller;

import com.moviemax.service.RestTemplatempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {
	@Autowired
	private RestTemplatempl movieService;

	@GetMapping("/movies")
	public String syncEmployees() {
		movieService.fetchAndSaveMovies();  
		return "Movies fetched and saved successfully!";
	}
}
