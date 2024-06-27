package com.riyality.mapper.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.patient.PatientAdmissionRequestDto;
import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;

@Component
public class PatientAdmissionMapper {

	public PatientAdmission toEntity( PatientAdmissionRequestDto requestDto ) {
		PatientAdmission entity = new PatientAdmission();

		entity.setAdmissionId( requestDto.getAdmissionId() );
		entity.setAdmissionDate( requestDto.getAdmissionDate() );
		entity.setDischargeDate( requestDto.getDischargeDate() );
		entity.setNextOfKinName( requestDto.getNextOfKinName() );
		entity.setNextOfKinRelationship( requestDto.getNextOfKinRelationship() );
		entity.setNextOfKinPhoneNumber( requestDto.getNextOfKinPhoneNumber() );
		entity.setAdmissionStatus( requestDto.getAdmissionStatus() );
		//entity.setDiagnosis(requestDto.getDiagnosis());
		return entity;
	}

	public PatientAdmissionResponseDto toDto( PatientAdmission entity ) {
		PatientAdmissionResponseDto dto = new PatientAdmissionResponseDto();

		dto.setAdmissionId( entity.getAdmissionId() );
		dto.setPatientId( entity.getPatient().getId() );
		dto.setWardId( entity.getWard().getId() );
		dto.setCotId( entity.getCot().getCotId() );
		dto.setAdmissionDate( entity.getAdmissionDate() );
		dto.setDischargeDate( entity.getDischargeDate() );
		dto.setDoctorId( entity.getDoctor().getId() );
		dto.setNextOfKinName( entity.getNextOfKinName() );
		dto.setNextOfKinRelationship( entity.getNextOfKinRelationship() );
		dto.setNextOfKinPhoneNumber( entity.getNextOfKinPhoneNumber() );
		dto.setBranchId( entity.getBranch().getId() );
		dto.setAdmissionStatus( entity.getAdmissionStatus() );
	//	dto.setDiagnosis(entity.getDiagnosis());
		return dto;
	}
	
	public List<PatientAdmissionResponseDto> toList( List<PatientAdmission> content ) {
		List<PatientAdmissionResponseDto> list = new ArrayList<>();
		for ( PatientAdmission dto : content )
			list.add( toDto( dto ) );
		
		return list;
	}
}
