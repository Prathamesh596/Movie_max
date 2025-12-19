package com.moviemax.service;

import com.moviemax.dto.ApiResponse;
import com.moviemax.dto.BookingDTO;
import com.moviemax.dto.BookingResponseDTO;
import com.moviemax.entities.Booking;

import java.util.List;

public interface BookingService {
	Booking createBooking(BookingDTO bookingRequest);

	List<BookingResponseDTO> getAllBookings();

	ApiResponse deleteBookingDetails(Long bookingId);

	BookingResponseDTO getBookingById(long id);

	List<BookingResponseDTO> getBookingsByUser(Long userId);
}
