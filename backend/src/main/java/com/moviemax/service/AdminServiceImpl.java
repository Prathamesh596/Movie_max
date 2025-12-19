package com.moviemax.service;

import com.moviemax.custom_exceptions.ResourceNotFoundException;
import com.moviemax.dto.AdminDTO;
import com.moviemax.dto.LoginRequestDTO;
import com.moviemax.entities.Admin;
import com.moviemax.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdminDTO authenticateAdmin(LoginRequestDTO dto) {
		Optional<Admin> optional = adminRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
		Admin admin = optional.orElseThrow(() -> new ResourceNotFoundException("Invalid Email & Password!!"));
		return modelMapper.map(admin, AdminDTO.class);
	}
}
