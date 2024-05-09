package com.riyality.dto.wrapper;

import java.util.List;

import com.riyality.dto.doctor.DoctorSpecializationDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorSpecializationDtoWrapper {
	List<DoctorSpecializationDto> doctorSpecializations;
}
