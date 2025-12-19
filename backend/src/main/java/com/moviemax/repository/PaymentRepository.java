package com.moviemax.repository;

import com.moviemax.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Payment findByOrderId(String orderId); // Add this method

}
