package com.moviemax.service;

import com.moviemax.dto.CastDTO;

public interface CastService {
	CastDTO getMoviesByType(String type);
}
