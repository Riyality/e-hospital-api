package com.riyality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.constants.MessageConstants;
import com.riyality.dto.doctor.DoctorSpecializationDto;
import com.riyality.dto.dropdowns.MedicineTypeDto;
import com.riyality.dto.wrapper.DoctorSpecializationDtoWrapper;
import com.riyality.service.DropdownService;

@RestController
@RequestMapping( "/drop-downs" )
public class DropdownController {

	@Autowired
	private DropdownService dropdownService;

	@PostMapping( "/specializations" )
	public ResponseEntity<String> addSpecialization( @RequestBody DoctorSpecializationDtoWrapper dto ) {
		boolean isAdded = dropdownService.addSpecialization( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_SPECIALIZATION_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_SPECIALIZATION_ERROR_MESSAGE );

	}

	@GetMapping( "/specializations" )
	public ResponseEntity<List<DoctorSpecializationDto>> allSpecializations() {
		return ResponseEntity.status( HttpStatus.OK ).body( dropdownService.getSpecialization() );

	}

	@GetMapping( "/medicine-types" )
	public ResponseEntity<List<MedicineTypeDto>> allMedicineTypes() {
		return ResponseEntity.status( HttpStatus.OK ).body( dropdownService.allMedicineTypes() );
	}
}
