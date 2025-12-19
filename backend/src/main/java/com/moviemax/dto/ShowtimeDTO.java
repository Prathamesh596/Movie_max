package com.moviemax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimeDTO extends BaseDTO {
	private LocalDate date;
	private LocalTime time;
	private int availableSeats;     
	private double amount;
	private MovieDTO movie;
	private TheaterDTO theater;
}
