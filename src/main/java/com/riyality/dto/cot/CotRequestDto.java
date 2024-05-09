package com.riyality.dto.cot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CotRequestDto {
	private Long id;
	private int cotNumber;
	private Long wardId;
	private String status;

}
