package com.riyality.dto.doctor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorSpecializationDto {
	private Long id;
	@NotNull
	@Size(max = 32)
	private String title;
}
