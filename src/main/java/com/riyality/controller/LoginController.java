package com.riyality.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.LoginRequestDto;
import com.riyality.dto.LoginResponceDto;
import com.riyality.service.LoginService;

@RestController
@RequestMapping( "/logins" )
@CrossOrigin( "*" )
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@PostMapping
	public ResponseEntity<LoginResponceDto> login( @RequestBody @Valid LoginRequestDto dto ) {
		LoginResponceDto loginDto = loginservice.login( dto );
		if ( loginDto != null ) {
			return ResponseEntity.status( HttpStatus.OK ).body( loginDto );
		} else {
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );

		}
	}
}
