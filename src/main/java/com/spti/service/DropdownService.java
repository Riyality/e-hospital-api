package com.spti.service;

import java.util.List;

import com.spti.dto.doctor.DoctorSpecializationDto;
import com.spti.dto.dropdowns.MedicineTypeDto;
import com.spti.dto.wrapper.DoctorSpecializationDtoWrapper;

public interface DropdownService {

	boolean addSpecialization( DoctorSpecializationDtoWrapper dto );

	List<DoctorSpecializationDto> getSpecialization();

	List<MedicineTypeDto> allMedicineTypes();

}
