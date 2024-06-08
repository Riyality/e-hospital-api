package com.riyality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.service.ReportsService;

@RestController
public class ReportsController {
	@Autowired
	ReportsService reports;
	@GetMapping("/reports/{type}/user/{user}")
	public List<PatientResponseDto> reportsPatients(@PathVariable String type,@PathVariable String user){
		List<PatientResponseDto> data=reports.findAllAdmittedPatients(type);
		return data;
	}

}
