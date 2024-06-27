package com.riyality.service;

import java.util.List;

import com.riyality.dto.patient.BillRequestDto;
import com.riyality.dto.patient.DischargeResponseDto;
import com.riyality.dto.patient.PatientAdmissionRequestDto;
import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;

public interface PatientAdmissionService {

	boolean addAdmission( PatientAdmissionRequestDto dto );

	DischargeResponseDto dischargePatient( Long id );

	List<PatientResponseDto> findAllAdmittedPatients( int branchId );

	String generateAndPayBill( BillRequestDto dto );

	DischargeResponseDto updateStatusPatient(Long id);

	List<PatientAdmissionResponseDto> findAdmissionDetailsByPatientId(Long id);


}
