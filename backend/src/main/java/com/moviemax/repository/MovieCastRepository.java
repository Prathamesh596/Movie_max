package com.moviemax.repository;

import com.moviemax.entities.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCastRepository extends JpaRepository<MovieCast, Long> {

}
