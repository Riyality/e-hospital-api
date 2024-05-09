package com.riyality.mapper.patient;

import org.springframework.stereotype.Component;

import com.riyality.dto.patient.PatientAdmissionRequestDto;
import com.riyality.dto.patient.PatientAdmissionResponseDto;
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
		return dto;
	}
}
