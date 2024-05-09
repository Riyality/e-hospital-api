package com.riyality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.insurance.InsuranceDetailRequestDto;
import com.riyality.dto.insurance.InsuranceDetailResponseDto;
import com.riyality.service.InsuranceDetailService;

@RestController
@RequestMapping( "/insurance-details" )
public class InsuranceDetailController {

	@Autowired
	private InsuranceDetailService insuranceDetailService;

	@PostMapping
	public ResponseEntity<InsuranceDetailResponseDto> addInsuranceDetail( @RequestBody InsuranceDetailRequestDto insuranceDetailRequestDto ) {
		InsuranceDetailResponseDto addedEntity = insuranceDetailService.addInsuranceDetail( insuranceDetailRequestDto );
		if ( addedEntity != null )
			return ResponseEntity.status( HttpStatus.CREATED ).body( addedEntity );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
	}

	@GetMapping( "/policy-number/{policyNumber}" )
	public ResponseEntity<InsuranceDetailResponseDto> getInsuranceDetailByPolicyNumber( @PathVariable String policyNumber ) {
		InsuranceDetailResponseDto dto = insuranceDetailService.getInsuranceDetailByPolicyNumber( policyNumber );
		return ResponseEntity.status( HttpStatus.OK ).body( dto );
	}
}
