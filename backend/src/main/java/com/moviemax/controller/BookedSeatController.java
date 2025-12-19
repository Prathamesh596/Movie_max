package com.moviemax.controller;

import com.moviemax.dto.BookedSeatDTO;
import com.moviemax.service.BookedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booked-seats")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend access
public class BookedSeatController {  
	@Autowired
	private BookedSeatService bookedSeatService;  

	@GetMapping("/showtime/{showtimeId}")
	public List<BookedSeatDTO> getBookedSeatsByShowtime(@PathVariable Long showtimeId) {
		return bookedSeatService.getAllSeatsByShowtimeId(showtimeId);       
	}
}
