package com.moviemax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter   
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO extends BaseDTO {
	private LocalDate bookingDate;
	private int noOfSeat;
	private long user;
	private long showtime;
	private List<String> seatNumbers; // List of seat numbers (e.g., ["A4", "B5", "C6"])
}
