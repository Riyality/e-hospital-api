package com.riyality.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riyality.dto.patient.PatientRequestDto;
import com.riyality.dto.patient.PatientResponseDto;

public interface PatientService {
	Page<PatientResponseDto> getAllPatients( int branchId, Pageable pageable );

	PatientResponseDto getPatientById( Long id );

	boolean addPatient( PatientRequestDto patientRequestDto );

	void deletePatient( Long id );

	boolean updatePatient( PatientRequestDto patientRequestDto );

	List<PatientResponseDto> findPatientsByPhoneNumber( int branchId, String phoneNumber );

	List<PatientResponseDto> findPatientsByPhoneNumber(String phoneNumber);
}
