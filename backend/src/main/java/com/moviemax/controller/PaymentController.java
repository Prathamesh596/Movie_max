package com.moviemax.controller;

import com.moviemax.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

	@Autowired    
	private PaymentService paymentService;

	@PostMapping("/create")
	public String createOrder(@RequestParam Long bookingId, @RequestParam double amount) {
		return paymentService.createOrder(bookingId, amount);
	}

	@PostMapping("/success")
	public void updatePaymentStatus(@RequestParam String orderId, @RequestParam String transactionId) {
		paymentService.updatePaymentStatus(orderId, transactionId);
	}
}
