package com.moviemax.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_casts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = { "casts" })
public class MovieCast extends BaseEntity {
//	@Column(length = 25)
	private String director;
//	@Column(length = 25)
	private String writer;

//	@OneToMany(mappedBy = "movieCast",cascade = CascadeType.ALL)
//	@JoinColumn(name = "movie_cast_id")
//	private List<Cast> casts; 
	@OneToMany(mappedBy = "movieCast", cascade = CascadeType.ALL)
	private List<Cast> casts=new ArrayList<>();
}   
