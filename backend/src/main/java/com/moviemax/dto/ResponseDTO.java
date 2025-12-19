package com.moviemax.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {
	private int page;
	private int total_pages;
	private int total_results;
	private MovieDTO[] results;
}
