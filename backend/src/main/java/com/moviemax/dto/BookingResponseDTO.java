package com.moviemax.dto;

import com.moviemax.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO extends BaseDTO {
	private LocalDate bookingDate;
	private int noOfSeat;
	private User user;
	private ShowtimeDTO showtime;
//	private List<String> seatNumbers; // List of seat numbers (e.g., ["A4", "B5", "C6"])
}
