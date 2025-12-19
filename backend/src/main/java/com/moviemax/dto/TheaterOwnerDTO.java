package com.moviemax.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviemax.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterOwnerDTO extends BaseDTO {
	private String name;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private List<TheaterDTO> theaters = new ArrayList<>();;
	private Role role;
}
