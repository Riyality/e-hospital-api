package com.riyality.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.ward.WardRequestDto;
import com.riyality.dto.ward.WardResponseDto;
import com.riyality.constants.MessageConstants;
import com.riyality.service.WardService;

@RestController
@RequestMapping( "/wards" )
public class WardController {

	@Autowired
	private WardService wardService;

	@PostMapping
	public ResponseEntity<String> addWard( @Valid @RequestBody WardRequestDto dto ) {
		boolean isAdded = wardService.addWard( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_WARD_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_WARD_ERROR_MESSAGE );

	}

	@GetMapping( "/branch/{branchId}" )
	public ResponseEntity<List<WardResponseDto>> allWards( @PathVariable int branchId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( wardService.allWards( branchId ) );

	}

	@GetMapping( "/id/{id}" )
	public ResponseEntity<WardResponseDto> wardById( @PathVariable Long id ) {

		return ResponseEntity.status( HttpStatus.OK ).body( wardService.wardById( id ) );

	}

	@PutMapping
	public ResponseEntity<String> updateWard( @Valid @RequestBody WardRequestDto dto ) {
		boolean isUpdate= wardService.updateWard( dto );
		if ( isUpdate )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_WARD_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_WARD_ERROR_MESSAGE );

	}

	@GetMapping( "/available-wards/{branchId}" )
	public ResponseEntity<List<WardResponseDto>> allAvailableWards( @PathVariable int branchId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( wardService.allAvailableWards( branchId ) );

	}

}
