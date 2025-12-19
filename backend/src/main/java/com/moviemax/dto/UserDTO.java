package com.moviemax.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviemax.entities.Gender;
import com.moviemax.entities.MaritalStatus;
import com.moviemax.entities.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserDTO extends BaseDTO {
	private String name;
	private String email;
	private String phone;
	private LocalDate dob;
	private Gender gender;
	private MaritalStatus maritalStatus;
	private Role role;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)   
	private String password;
}
