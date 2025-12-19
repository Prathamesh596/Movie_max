package com.moviemax.repository;

import com.moviemax.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByEmailAndPassword(String em, String pwd);
}
