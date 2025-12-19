package com.moviemax.service;

import com.moviemax.dto.AdminDTO;
import com.moviemax.dto.LoginRequestDTO;

public interface AdminService {
	AdminDTO authenticateAdmin(LoginRequestDTO dto);
}
