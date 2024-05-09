package com.riyality.dto.ward;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WardResponseDto {
	private Long id;
	private String wardName;
	private int maxCapacity;
	private int currentOccupancy;
	private int floorNumber;
	private String wing;
	private String status;
	private int branch;
	private int charges;
}
