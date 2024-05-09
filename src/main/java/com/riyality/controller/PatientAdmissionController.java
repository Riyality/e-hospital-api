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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.constants.MessageConstants;
import com.riyality.dto.patient.BillRequestDto;
import com.riyality.dto.patient.DischargeResponseDto;
import com.riyality.dto.patient.PatientAdmissionRequestDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.service.PatientAdmissionService;

@RestController
@RequestMapping( "/admissions" )
public class PatientAdmissionController {

	@Autowired
	private PatientAdmissionService admissionService;

	@PostMapping
	public ResponseEntity<String> addAdmission( @Valid @RequestBody PatientAdmissionRequestDto dto ) {
		boolean isAdded = admissionService.addAdmission( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_ADMISSION_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_ADMISSION_ERROR_MESSAGE );

	}

	@GetMapping( "/discharge-info/patient/{id}" )
	public ResponseEntity<DischargeResponseDto> dischargePatient( @PathVariable Long id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( admissionService.dischargePatient( id ) );
	}

	@GetMapping( "/current-admissions/branch/{branchId}" )
	public ResponseEntity<List<PatientResponseDto>> findAllAdmittedPatients( @PathVariable int branchId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( admissionService.findAllAdmittedPatients( branchId ) );
	}

	@ResponseBody
	@PostMapping( "/bills/admissions" )
	public ResponseEntity<String> generateAndPayBill( @RequestBody BillRequestDto dto ) {
		String result = admissionService.generateAndPayBill( dto );
		if ( result.equals( "success" ) )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.BILL_PAID_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.BILL_PAID_FAIL_MESSAGE );
	}
}
