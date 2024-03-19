package com.spti.service;

import java.util.List;

import com.spti.dto.prescriptions.MedicineResponseDto;
import com.spti.dto.prescriptions.PrescriptionRequestDto;
import com.spti.dto.prescriptions.PrescriptionResponseDto;

public interface PrescriptionService {

	boolean addPrescription( PrescriptionRequestDto dto );

	List<PrescriptionResponseDto> findAllPrescription( Long id );

	List<MedicineResponseDto> findMedicineByPrescriptionId( Long prescriptionId );

	public List<PrescriptionResponseDto> findTopById( Long patientId );

}
