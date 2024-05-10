package com.riyality.dto.ward;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WardRequestDto {
	private Long id;
	@NotNull
    @Size(max = 32)
	private String wardName;
	@NotNull
	private int maxCapacity;
	private int currentOccupancy;
	private int floorNumber;
	@NotNull
	@Size(max = 16)
	private String wing;
	@NotNull
	@Size(max = 16)
	private String status;
	
	private int branch;
	private int charges;
}
