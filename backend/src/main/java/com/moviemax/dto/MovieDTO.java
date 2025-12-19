package com.moviemax.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDTO extends BaseDTO {
	private long movieId;
	private String title;
	private String overview;
	private double vote_average;
	private int vote_count;
	private String release_date;
	private String backdrop_path;
	private String poster_path;
	private String status;
	private String tagline;
	private int revenue;
	private int runtime;
	private String type;
	private String category; 
}
