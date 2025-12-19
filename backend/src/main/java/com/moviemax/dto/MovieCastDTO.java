package com.moviemax.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieCastDTO extends BaseDTO {
	private String director;
	private String writer;
	private List<CastDTO> casts=new ArrayList<>();   
}
