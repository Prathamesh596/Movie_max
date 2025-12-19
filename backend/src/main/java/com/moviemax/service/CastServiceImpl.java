package com.moviemax.service;

import com.moviemax.dto.CastDTO;
import com.moviemax.repository.CastRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CastServiceImpl implements CastService {
	@Autowired
	private CastRepository castRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CastDTO getMoviesByType(String type) {
		return null;
	}

}
