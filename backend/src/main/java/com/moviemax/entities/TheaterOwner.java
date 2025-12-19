package com.moviemax.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter  
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class TheaterOwner extends BaseEntity {
	@Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Enumerated(EnumType.STRING)
	private Role role=Role.THEATER_OWNER;
    
    @Column(name = "password", nullable = false)
	private String password;  

    @OneToMany(mappedBy = "theaterOwner", cascade = CascadeType.ALL)
    private List<Theater> theaters;
}
