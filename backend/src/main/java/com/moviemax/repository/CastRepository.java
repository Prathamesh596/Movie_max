package com.moviemax.repository;

import com.moviemax.entities.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<Cast, Long> {
	
}
