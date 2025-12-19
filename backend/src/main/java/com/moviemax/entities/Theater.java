package com.moviemax.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@ToString(callSuper = true)
class Theater extends BaseEntity {
	@Column(unique = true, length = 40)
	private String name;
	@Column(length = 40)
	private String location;

	@ManyToOne
	@JoinColumn(name = "theater_Ownerid", nullable = false)
	private TheaterOwner theaterOwner;
}
