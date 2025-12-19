package com.moviemax.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {
	@Column(length = 25)
	private String name;
	@Column(length = 30, unique = true)
	private String email;   
	@Column(length = 25, unique = true)
	private String phone;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private Gender gender;  
	@Enumerated(EnumType.STRING)  
	private MaritalStatus maritalStatus;     
	@Column(length = 50)
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role=Role.USER;    
}
