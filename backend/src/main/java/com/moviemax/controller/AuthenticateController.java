package com.moviemax.controller;

import com.moviemax.custom_exceptions.ResourceNotFoundException;
import com.moviemax.dto.*;
import com.moviemax.service.AdminService;
import com.moviemax.service.OTPServiceImpl;
import com.moviemax.service.TheaterOwnerService;
import com.moviemax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/signin")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticateController {
	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private TheaterOwnerService theaterOwnerService;

	@Autowired
	private OTPServiceImpl otpService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
	    System.out.println("In authenticateUser " + loginRequest);

	    try {
	        AdminDTO admin = adminService.authenticateAdmin(loginRequest);
	        if (admin != null) {
	            otpService.sendOTP(admin.getEmail());
	            return ResponseEntity.ok(new ApiResponse("OTP sent to your email.", admin));
	        }
	    } catch (ResourceNotFoundException e) {
	        // Ignore and continue checking next role 
	    }

	    try {
	        TheaterOwnerDTO owner = theaterOwnerService.authenticateOwner(loginRequest);
	        if (owner != null) {
	            otpService.sendOTP(owner.getEmail());
	            return ResponseEntity.ok(new ApiResponse("OTP sent to your email.", owner));
	        }
	    } catch (ResourceNotFoundException e) {
	        // Ignore and continue checking next role
	    }

	    try {
	        UserDTO user = userService.authenticateUser(loginRequest);
	        if (user != null) {
	            otpService.sendOTP(user.getEmail());
	            return ResponseEntity.ok(new ApiResponse("OTP sent to your email.", user));
	        }
	    } catch (ResourceNotFoundException e) {
	        // Ignore and return final error if no users are found
	    }

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid email or password"));
	}


}
