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

import com.riyality.dto.cot.CotRequestDto;
import com.riyality.dto.cot.CotResponseDto;
import com.riyality.constants.MessageConstants;
import com.riyality.service.CotService;

@RestController
@RequestMapping( "/cots" )
public class CotController {

	@Autowired
	private CotService cotService;

	@PostMapping
	public ResponseEntity<String> addCot( @Valid @RequestBody CotRequestDto dto ) {
		boolean isAdded = cotService.addCot( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_COT_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_COT_ERROR_MESSAGE );

	}

	@GetMapping( "/available/wards/{id}" )
	public ResponseEntity<List<CotResponseDto>> availableCots( @PathVariable Long id ) {

		return ResponseEntity.status( HttpStatus.CREATED ).body( cotService.availableCots( id ) );

	}

	@GetMapping( "/wards/{id}" )
	public ResponseEntity<List<CotResponseDto>> allCots( @PathVariable Long id ) {

		return ResponseEntity.status( HttpStatus.CREATED ).body( cotService.allCots( id ) );

	}

}
