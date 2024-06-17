package com.riyality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.service.ReportsService;

@RestController
public class ReportsController {
	@Autowired
	ReportsService reports;
	@GetMapping("/reports/{type}/user/{user}")
	public ResponseEntity<List<PatientAdmissionResponseDto>> reportsPatients(@PathVariable String type,@PathVariable String user){
		ResponseEntity<List<PatientAdmissionResponseDto>> data=ResponseEntity.status( HttpStatus.OK ).body(reports.findAllAdmittedPatients(type));
		return data;
	}

}
