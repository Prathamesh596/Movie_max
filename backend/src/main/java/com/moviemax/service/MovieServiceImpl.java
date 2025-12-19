package com.moviemax.service;

import com.moviemax.dto.MovieCastDTO;
import com.moviemax.dto.MovieDTO;
import com.moviemax.entities.MovieCast;
import com.moviemax.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<MovieDTO> getMoviesByType(String type) {
		return movieRepository.findByType(type).stream().map(movie -> modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());
	}

	public MovieCastDTO getMovieCastByMovieId(long id) {
		return movieRepository.findById(id).map(movie -> {
			MovieCast movieCast = movie.getMovieCasts();
			// Ensure cast is fetched
//	                movieCast.getCasts().size();  
			return modelMapper.map(movieCast, MovieCastDTO.class);
		}).orElse(null);
	}

	@Override
	public MovieDTO getMoviesById(long id) {
		return movieRepository.findById(id).map(movie -> modelMapper.map(movie, MovieDTO.class)).orElse(null);
	}

	public List<MovieDTO> searchMovies(String title) {
		return movieRepository.findByTitleContainingIgnoreCase(title).stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
	}

	public List<MovieDTO> getFilteredMovies(String status, String category, Double rating, String type) {
		return movieRepository.filterMovies(status, category, rating, type).stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
	}
}
