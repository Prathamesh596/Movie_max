package com.moviemax.repository;

import com.moviemax.entities.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TheaterOwnerRepository extends JpaRepository<TheaterOwner, Long> {
	Optional<TheaterOwner> findByEmailAndPassword(String em, String pwd);
}
