package com.moviemax.service;

import com.moviemax.custom_exceptions.ResourceNotFoundException;
import com.moviemax.dto.ApiResponse;
import com.moviemax.dto.LoginRequestDTO;
import com.moviemax.dto.TheaterOwnerDTO;
import com.moviemax.entities.TheaterOwner;
import com.moviemax.repository.TheaterOwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TheaterOwnerServiceImpl implements TheaterOwnerService {
	@Autowired
	private TheaterOwnerRepository theaterOwnerRepository;

	@Autowired
	private ModelMapper modelMapper;         

	@Override
	public TheaterOwnerDTO authenticateOwner(LoginRequestDTO dto) {
		Optional<TheaterOwner> optional = theaterOwnerRepository.findByEmailAndPassword(dto.getEmail(),
				dto.getPassword());
		TheaterOwner theaterOwner = optional  
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email & Password!!"));
		return modelMapper.map(theaterOwner, TheaterOwnerDTO.class);
	}

	@Override
	public List<TheaterOwnerDTO> getAllTheaterOwner() {
		return theaterOwnerRepository.findAll().stream()
				.map(theaterOwner -> modelMapper.map(theaterOwner, TheaterOwnerDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteTheaterOwnerDetails(Long ownerId) {
		if (theaterOwnerRepository.existsById(ownerId)) {
			theaterOwnerRepository.deleteById(ownerId);
			return new ApiResponse("Deleted Owner Details !!!");
		}
		return new ApiResponse("Invalid Owner Id !!!");
	}

	@Override
	public TheaterOwnerDTO getTheaterOwneById(long id) {
		return theaterOwnerRepository.findById(id)
				.map(theaterOwner -> modelMapper.map(theaterOwner, TheaterOwnerDTO.class)).orElse(null);
	}

}
