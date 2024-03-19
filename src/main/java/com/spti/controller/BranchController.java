package com.spti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spti.dto.BranchRequestDto;
import com.spti.service.BranchService;

@RestController
@RequestMapping( "/branch" )
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping( "/id/{id}" )
	public ResponseEntity<BranchRequestDto> getById( @PathVariable int id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( branchService.getById( id ) );
	}
}
