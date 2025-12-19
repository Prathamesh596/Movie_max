package com.moviemax.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CastDTO extends BaseDTO {
	private Long castId;
	private String name;
	private String profile_path;
}
