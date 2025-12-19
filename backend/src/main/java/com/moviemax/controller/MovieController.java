package com.moviemax.controller;

import com.moviemax.dto.MovieCastDTO;
import com.moviemax.dto.MovieDTO;
import com.moviemax.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping("/{type}/type")
	public List<MovieDTO> getMoviesByType(@PathVariable String type) {
		return movieService.getMoviesByType(type);
	}

	@GetMapping("/{id}")
	public MovieDTO getMoviesById(@PathVariable long id) {
		return movieService.getMoviesById(id);
	}

	@GetMapping("/{id}/cast")
	public MovieCastDTO getMovieCastByMovieId(@PathVariable long id) {
		return movieService.getMovieCastByMovieId(id);
	}

	@GetMapping("/search")
	public List<MovieDTO> searchMovies(@RequestParam String title) {
		return movieService.searchMovies(title);
	}

	@GetMapping("/{type}/filter")
	public List<MovieDTO> filterMovies(@RequestParam(required = false) String status,
			@RequestParam(required = false) String category, @RequestParam(required = false) Double rating,
			@PathVariable String type) {

		// Convert empty strings to NULL
		if (status != null && status.isEmpty())
			status = null;
		if (category != null && category.isEmpty())
			category = null;

		// Convert 0 rating to NULL (if 0 means "no filter")
		if (rating != null && rating == 0)
			rating = null;

		return movieService.getFilteredMovies(status, category, rating, type);
	}
}
