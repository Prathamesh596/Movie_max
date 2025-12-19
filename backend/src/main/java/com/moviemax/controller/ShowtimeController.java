package com.moviemax.controller;

import com.moviemax.dto.ShowtimeDTO;
import com.moviemax.service.ShowtimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
@CrossOrigin(origins = "http://localhost:5173") // Adjust as needed
public class ShowtimeController {

	private final ShowtimeService showtimeService;

	public ShowtimeController(ShowtimeService showtimeService) {
		this.showtimeService = showtimeService;
	}

	// Get showtimes for a specific movie
	@GetMapping("/movie/{movieId}")
	public List<ShowtimeDTO> getShowtimesByMovie(@PathVariable Long movieId) {
		return showtimeService.getShowtimesByMovie(movieId);
	}
}
