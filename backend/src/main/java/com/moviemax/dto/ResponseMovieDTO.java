package com.moviemax.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseMovieDTO {
	private String status;
	private String tagline;
	private int revenue;
	private int runtime;
}
