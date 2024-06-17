package com.riyality.service;

import java.util.List;

import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;

public interface ReportsService {

	List<PatientResponseDto> reportsPatients(String type, String user);

	List<PatientAdmissionResponseDto> findAllAdmittedPatients(String type);



	

}
