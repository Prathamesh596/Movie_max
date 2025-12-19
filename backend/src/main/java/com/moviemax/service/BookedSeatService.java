package com.moviemax.service;

import com.moviemax.dto.BookedSeatDTO;

import java.util.List;

public interface BookedSeatService {
	List<BookedSeatDTO> getAllSeatsByShowtimeId(Long showtimeId);
}
