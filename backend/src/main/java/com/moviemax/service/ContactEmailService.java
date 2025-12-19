package com.moviemax.service;

import com.moviemax.entities.ContactRequest;
import jakarta.mail.MessagingException;

public interface ContactEmailService {
	void sendEmail(ContactRequest request) throws MessagingException;
}
