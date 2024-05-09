package com.riyality.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.constants.MessageConstants;
import com.riyality.dto.prescriptions.MedicineResponseDto;
import com.riyality.dto.prescriptions.PrescriptionRequestDto;
import com.riyality.dto.prescriptions.PrescriptionResponseDto;
import com.riyality.service.PrescriptionService;

@RestController
@RequestMapping( "/prescriptions" )
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;

	@PostMapping
	public ResponseEntity<String> addPrescription( @Valid @RequestBody PrescriptionRequestDto dto ) {
		boolean isAdded = prescriptionService.addPrescription( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_PRESCRIPTION_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_PRESCRIPTION_ERROR_MESSAGE );

	}

	@GetMapping( "/allPrescriptions/{id}" )
	public ResponseEntity<List<PrescriptionResponseDto>> findAllPrescription( @PathVariable Long id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( prescriptionService.findAllPrescription( id ) );
	}

	@GetMapping( "/medicine/{prescriptionId}" )
	public ResponseEntity<List<MedicineResponseDto>> findMedicineByPrescriptionId( @PathVariable Long prescriptionId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( prescriptionService.findMedicineByPrescriptionId( prescriptionId ) );
	}

	@GetMapping( "/lastPrescriptions/{patientId}" )
	public ResponseEntity<List<PrescriptionResponseDto>> findTopById( @PathVariable Long patientId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( prescriptionService.findTopById( patientId ) );
	}
}
