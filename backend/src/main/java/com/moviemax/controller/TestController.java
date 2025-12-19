package com.moviemax.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
	@GetMapping("/test")
	public List<Integer> test() {
		return List.of(1, 2, 3);
	}
}
