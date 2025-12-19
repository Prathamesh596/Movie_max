package com.moviemax.service;

import com.moviemax.dto.ShowtimeDTO;
import com.moviemax.repository.ShowtimeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
	@Autowired
	private ShowtimeRepository showtimeRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<ShowtimeDTO> getShowtimesByMovie(Long movieId) {   
		return showtimeRepository.findByMovieId(movieId).stream()
				.map(showtime -> modelMapper.map(showtime, ShowtimeDTO.class)).collect(Collectors.toList());
	}

}
