package com.moviemax.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	private UserDTO user; // changes
	private TheaterOwnerDTO theaterOwner;
	private AdminDTO admin;

	public ApiResponse(String message) {
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}

	// changes
	public ApiResponse(String message, UserDTO user) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
		this.user = user;
	}
	
	public ApiResponse(String message, TheaterOwnerDTO theaterOwner) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
		this.theaterOwner = theaterOwner;
	}
	
	public ApiResponse(String message, AdminDTO adminDTO) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
		this.admin = adminDTO;   
	}
}