package com.moviemax.service;

import com.moviemax.dto.MovieCastDTO;
import com.moviemax.dto.MovieDTO;

import java.util.List;

public interface MovieService {
	List<MovieDTO> getMoviesByType(String type);

	MovieCastDTO getMovieCastByMovieId(long id);

	MovieDTO getMoviesById(long id);

	List<MovieDTO> searchMovies(String title);

	List<MovieDTO> getFilteredMovies(String status, String category, Double rating, String type);
}
