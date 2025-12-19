package com.moviemax.service;

import com.moviemax.dto.ShowtimeDTO;

import java.util.List;

public interface ShowtimeService {
	List<ShowtimeDTO> getShowtimesByMovie(Long movieId);
}
