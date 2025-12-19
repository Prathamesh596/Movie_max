package com.moviemax.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Showtimes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = { "movie", "theater" })
public class Showtime extends BaseEntity {
	private LocalDate date;
	private LocalTime time;
	private int availableSeats;   
	private double amount;
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "theaterId")
	private Theater theater;
}
