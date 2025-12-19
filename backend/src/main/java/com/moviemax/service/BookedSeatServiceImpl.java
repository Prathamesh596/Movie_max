package com.moviemax.service;

import com.moviemax.dto.BookedSeatDTO;
import com.moviemax.repository.BookedSeatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookedSeatServiceImpl implements BookedSeatService {

	@Autowired
	private BookedSeatRepository bookedSeatRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<BookedSeatDTO> getAllSeatsByShowtimeId(Long showtimeId) {
		return bookedSeatRepository.findByShowtimeId(showtimeId).stream()
				.map(bookedSeat -> modelMapper.map(bookedSeat, BookedSeatDTO.class)).collect(Collectors.toList());
	}
}
