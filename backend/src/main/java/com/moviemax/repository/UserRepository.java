package com.moviemax.repository;

import com.moviemax.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPassword(String em, String pwd);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhone(String phone);
}