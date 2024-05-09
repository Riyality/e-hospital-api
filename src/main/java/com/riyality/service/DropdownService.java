package com.riyality.service;

import java.util.List;

import com.riyality.dto.doctor.DoctorSpecializationDto;
import com.riyality.dto.dropdowns.MedicineTypeDto;
import com.riyality.dto.wrapper.DoctorSpecializationDtoWrapper;

public interface DropdownService {

	boolean addSpecialization( DoctorSpecializationDtoWrapper dto );

	List<DoctorSpecializationDto> getSpecialization();

	List<MedicineTypeDto> allMedicineTypes();

}
