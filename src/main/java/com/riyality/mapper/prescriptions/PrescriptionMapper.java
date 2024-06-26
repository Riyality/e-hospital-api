package com.riyality.mapper.prescriptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.prescriptions.PrescriptionRequestDto;
import com.riyality.dto.prescriptions.PrescriptionResponseDto;
import com.riyality.entity.Prescription;

@Component
public class PrescriptionMapper {

	public Prescription toEntity( PrescriptionRequestDto requestDto ) {
		Prescription entity = new Prescription();
		entity.setPrescriptionId( requestDto.getPrescriptionId() );
		//entity.setPatientId( requestDto.getPatientId() );
		//entity.setDoctorId( requestDto.getDoctorId() );
		entity.setPrescription_date( requestDto.getPrescriptionDate() );
		entity.setPrescription( requestDto.getPrescription() );

		//entity.setDiagnosis(requestDto.getDiagnosis());          

		return entity;
	}

	public PrescriptionResponseDto toDto( Prescription entity ) {
		PrescriptionResponseDto dto = new PrescriptionResponseDto();
		dto.setPrescriptionId( entity.getPrescriptionId() );
		dto.setPatientId( entity.getPatient().getId() );
	//	dto.setDiagnosis(entity.getPatient().getDiagnosis());
		dto.setDoctorId( entity.getDoctor().getId() );
		dto.setDoctorName(entity.getDoctor().getFirstName()+" "+entity.getDoctor().getLastName());
		dto.setPrescriptionDate( entity.getPrescription_date() );
		dto.setPrescription( entity.getPrescription() );
		return dto;
	}
	
	public List<PrescriptionResponseDto> toList( List<Prescription> list ) {
		List<PrescriptionResponseDto> dtoList = new ArrayList<>();
		for ( Prescription dto : list ) {
			dtoList.add( toDto( dto ) );
		}
		return dtoList;
	}
}
