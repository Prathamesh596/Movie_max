package com.moviemax.service;

import com.moviemax.dto.ApiResponse;
import com.moviemax.dto.BookingDTO;
import com.moviemax.dto.BookingResponseDTO;
import com.moviemax.entities.BookedSeat;
import com.moviemax.entities.Booking;
import com.moviemax.entities.Showtime;
import com.moviemax.entities.User;
import com.moviemax.repository.BookedSeatRepository;
import com.moviemax.repository.BookingRepository;
import com.moviemax.repository.ShowtimeRepository;
import com.moviemax.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShowtimeRepository showtimeRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookedSeatRepository bookedSeatRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Booking createBooking(BookingDTO bookingRequest) {
		User user = userRepository.findById(bookingRequest.getUser())
				.orElseThrow(() -> new RuntimeException("Showtime not found"));
		Showtime showtime = showtimeRepository.findById(bookingRequest.getShowtime())
				.orElseThrow(() -> new RuntimeException("Showtime not found"));

		Booking booking = new Booking();
		booking.setShowtime(showtime); // Assign the fetched showtime
		booking.setUser(user);
		booking.setNoOfSeat(bookingRequest.getNoOfSeat());
		booking.setBookingDate(bookingRequest.getBookingDate());

		// Save the booking
		Booking savedBooking = bookingRepository.save(booking);

		// Create and save booked seats
		List<BookedSeat> bookedSeats = bookingRequest.getSeatNumbers().stream().map(seatNo -> {
			BookedSeat bookedSeat = new BookedSeat();
			bookedSeat.setSeatNo(seatNo); // Set seat number
			bookedSeat.setBooking(savedBooking);
			bookedSeat.setShowtime(savedBooking.getShowtime());
			return bookedSeat;
		}).toList();

		bookedSeatRepository.saveAll(bookedSeats);

		return savedBooking;
	}

	@Override
	public List<BookingResponseDTO> getAllBookings() {
		return bookingRepository.findAll().stream().map(booking -> modelMapper.map(booking, BookingResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteBookingDetails(Long bookingId) {
		if (bookingRepository.existsById(bookingId)) {
			bookingRepository.deleteById(bookingId);
			return new ApiResponse("Deleted Owner Details !!!");
		}
		return new ApiResponse("Invalid Owner Id !!!");
	}

	@Override
	public BookingResponseDTO getBookingById(long id) {
		return bookingRepository.findById(id).map(booking -> modelMapper.map(booking, BookingResponseDTO.class))
				.orElse(null);
	}

	public List<BookingResponseDTO> getBookingsByUser(Long userId) {
		return bookingRepository.findByUserId(userId).stream().map(booking -> modelMapper.map(booking, BookingResponseDTO.class))
				.collect(Collectors.toList());
	}

}
