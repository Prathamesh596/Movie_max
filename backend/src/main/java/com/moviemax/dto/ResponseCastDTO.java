package com.moviemax.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseCastDTO {
	private Long id;
	private CastDTO[] cast;
	private CrewDTO[] crew;	
}
