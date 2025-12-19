package com.moviemax.controller;

import com.moviemax.dto.BookingDTO;
import com.moviemax.dto.BookingResponseDTO;
import com.moviemax.entities.Booking;
import com.moviemax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/create")
	public ResponseEntity<Long> createBooking(@RequestBody BookingDTO bookingRequest) {
		Booking savedBooking = bookingService.createBooking(bookingRequest);
		return ResponseEntity.ok(savedBooking.getId());
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllBookings() {
		System.out.println("in get all users");
		List<BookingResponseDTO> theaterOwner = bookingService.getAllBookings();
		if (theaterOwner.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(theaterOwner);
	}

	@DeleteMapping("/deleteUser/{bookingId}")
	public ResponseEntity<?> deleteBookingDetails(@PathVariable Long bookingId) {
		System.out.println("in delete booking details " + bookingId);

		return ResponseEntity.ok(bookingService.deleteBookingDetails(bookingId));
	}

	@GetMapping("/{id}")
	public BookingResponseDTO getTheaterOwnerById(@PathVariable long id) {
		return bookingService.getBookingById(id);   
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BookingResponseDTO>> getBookingsByUser(@PathVariable Long userId) {
		List<BookingResponseDTO> bookings = bookingService.getBookingsByUser(userId);  
		return ResponseEntity.ok(bookings);    
	}
}
