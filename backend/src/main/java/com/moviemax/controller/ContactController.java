package com.moviemax.controller;

import com.moviemax.entities.ContactRequest;
import com.moviemax.service.ContactEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")  
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

	@Autowired
	private ContactEmailService contactEmailService;

	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody ContactRequest request) {
		try {
			contactEmailService.sendEmail(request);
			return ResponseEntity.ok("Email sent successfully!");    
		} catch (MessagingException e) {
			return ResponseEntity.status(500).body("Error sending email: " + e.getMessage());
		}
	}
}
