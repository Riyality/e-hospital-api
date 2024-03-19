package com.spti.service;

import java.util.List;

import com.spti.dto.patient.BillRequestDto;
import com.spti.dto.patient.DischargeResponseDto;
import com.spti.dto.patient.PatientAdmissionRequestDto;
import com.spti.dto.patient.PatientResponseDto;

public interface PatientAdmissionService {

	boolean addAdmission( PatientAdmissionRequestDto dto );

	DischargeResponseDto dischargePatient( Long id );

	List<PatientResponseDto> findAllAdmittedPatients( int branchId );

	String generateAndPayBill( BillRequestDto dto );

}
