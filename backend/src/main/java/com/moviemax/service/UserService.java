package com.moviemax.service;

import com.moviemax.dto.ApiResponse;
import com.moviemax.dto.LoginRequestDTO;
import com.moviemax.dto.UserDTO;
import com.moviemax.entities.User;

import java.util.List;

public interface UserService {
	// Add method to add user details
	String addNewUser(UserDTO userDTO);
	
	// Add method to signin user
	UserDTO authenticateUser(UserDTO dto);
	
	UserDTO authenticateUser(LoginRequestDTO dto);

	//Add method to get all users
	List<UserDTO> getAllUsers();

	// Update user details
	ApiResponse updateUserDetails(Long userId, User user);

	boolean checkEmailExists(String email);

	boolean validatePhone(String phone);

	ApiResponse deleteUserDetails(Long userId);	
}
