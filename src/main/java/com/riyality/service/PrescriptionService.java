package com.riyality.service;

import java.util.List;

import com.riyality.dto.prescriptions.MedicineResponseDto;
import com.riyality.dto.prescriptions.PrescriptionRequestDto;
import com.riyality.dto.prescriptions.PrescriptionResponseDto;

public interface PrescriptionService {

	boolean addPrescription( PrescriptionRequestDto dto );

	List<PrescriptionResponseDto> findAllPrescription( Long id );

	List<MedicineResponseDto> findMedicineByPrescriptionId( Long prescriptionId );

	public List<PrescriptionResponseDto> findTopById( Long patientId );

}
