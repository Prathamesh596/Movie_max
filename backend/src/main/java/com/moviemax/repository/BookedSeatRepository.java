package com.moviemax.repository;

import com.moviemax.entities.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {
	List<BookedSeat> findByShowtimeId(Long showtimeId);
}
