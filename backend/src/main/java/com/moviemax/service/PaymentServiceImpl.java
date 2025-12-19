package com.moviemax.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.moviemax.entities.Booking;
import com.moviemax.entities.Payment;
import com.moviemax.repository.BookingRepository;
import com.moviemax.repository.PaymentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Value("${razorpay.key_id}")
	private String keyId;

	@Value("${razorpay.key_secret}")
	private String keySecret;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BookingRepository bookingRepository;

	public String createOrder(Long bookingId, double amount) {
		try {
			RazorpayClient client = new RazorpayClient(keyId, keySecret);

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", (int) (amount * 100)); // Convert to paise
			orderRequest.put("currency", "INR");
			orderRequest.put("payment_capture", 1); // Auto capture

			Order order = client.orders.create(orderRequest);

			// Save order details in DB
			Optional<Booking> booking = bookingRepository.findById(bookingId);
			if (booking.isPresent()) {
				Payment payment = new Payment();
				payment.setAmount(amount);
				payment.setPaymentDate(LocalDate.now());
				payment.setPaymentMethod("RAZORPAY");
				payment.setPaymentStatus("PENDING");
				payment.setOrderId(order.get("id"));
				payment.setTransactionId(""); // Will be updated on success
				payment.setBooking(booking.get());
				paymentRepository.save(payment);
			}

			return order.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updatePaymentStatus(String orderId, String transactionId) {
		Payment payment = paymentRepository.findByOrderId(orderId);
		if (payment != null) {
			payment.setTransactionId(transactionId);
			payment.setPaymentStatus("SUCCESS");
			paymentRepository.save(payment);
		}
	}
}
