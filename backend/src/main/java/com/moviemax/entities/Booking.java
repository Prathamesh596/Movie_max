package com.moviemax.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = { "showtime", "user" })
public class Booking extends BaseEntity {
	@CreationTimestamp
	private LocalDate bookingDate;
	private int noOfSeat;
	@Column(length = 25)
	private String paymentStatus;

	// ONE booking belongs to ONE showtime
	@ManyToOne
	@JoinColumn(name = "showtime_id", nullable = false)
	private Showtime showtime;

	// ONE booking belongs to ONE user
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)   
	private User user;

	// ONE booking can have MANY booked seats
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookedSeat> bookedSeats;

}
