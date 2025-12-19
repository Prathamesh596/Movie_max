package com.moviemax.service;

import com.moviemax.dto.ApiResponse;
import com.moviemax.dto.LoginRequestDTO;
import com.moviemax.dto.TheaterOwnerDTO;

import java.util.List;

public interface TheaterOwnerService {

	List<TheaterOwnerDTO> getAllTheaterOwner();

	ApiResponse deleteTheaterOwnerDetails(Long ownerId);

	TheaterOwnerDTO getTheaterOwneById(long id);

	TheaterOwnerDTO authenticateOwner(LoginRequestDTO dto);
}
