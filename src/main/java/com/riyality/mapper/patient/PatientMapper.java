package com.riyality.mapper.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.patient.PatientRequestDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Patient;

@Component
public class PatientMapper {

	public Patient toEntity( PatientRequestDto requestDto ) {
		Patient entity = new Patient();

		entity.setId( requestDto.getId() );
		entity.setFirstName( requestDto.getFirstName() );
		entity.setLastName( requestDto.getLastName() );
		entity.setGender( requestDto.getGender() );
		entity.setDateOfBirth( requestDto.getDateOfBirth() );
		entity.setAddress( requestDto.getAddress() );
		entity.setPhoneNumber( requestDto.getPhoneNumber() );
		entity.setEmail( requestDto.getEmail() );
		entity.setEmergencyContactName( requestDto.getEmergencyContactName() );
		entity.setEmergencyContactNumber( requestDto.getEmergencyContactNumber() );
		entity.setBloodType( requestDto.getBloodType() );
		entity.setAllergies( requestDto.getAllergies() );
		entity.setMedicalHistory( requestDto.getMedicalHistory() );
		entity.setOccupation( requestDto.getOccupation() );
		entity.setMaritalStatus( requestDto.getMaritalStatus() );
		entity.setNationality( requestDto.getNationality() );
		entity.setLanguageSpoken( requestDto.getLanguageSpoken() );
		entity.setReligion( requestDto.getReligion() );
		entity.setAdmissionStatus( requestDto.getAdmissionStatus() );
		return entity;
	}

	public PatientResponseDto toDto( Patient entity ) {
		PatientResponseDto dto = new PatientResponseDto();

		dto.setId( entity.getId() );
		dto.setFirstName( entity.getFirstName() );
		dto.setLastName( entity.getLastName() );
		dto.setGender( entity.getGender() );
		dto.setDateOfBirth( entity.getDateOfBirth() );
		dto.setAddress( entity.getAddress() );
		dto.setPhoneNumber( entity.getPhoneNumber() );
		dto.setEmail( entity.getEmail() );
		dto.setEmergencyContactName( entity.getEmergencyContactName() );
		dto.setEmergencyContactNumber( entity.getEmergencyContactNumber() );
		dto.setBloodType( entity.getBloodType() );
		dto.setAllergies( entity.getAllergies() );
		dto.setMedicalHistory( entity.getMedicalHistory() );
		dto.setOccupation( entity.getOccupation() );
		dto.setMaritalStatus( entity.getMaritalStatus() );
		dto.setNationality( entity.getNationality() );
		dto.setLanguageSpoken( entity.getLanguageSpoken() );
		dto.setReligion( entity.getReligion() );
		if ( entity.getInsuranceDetail() != null )
			dto.setInsuranceId( entity.getInsuranceDetail().getId() );
		dto.setBranch( entity.getBranch().getId() );
		if ( entity.getDoctor() != null )
			dto.setDoctorId( entity.getDoctor().getId() );
		dto.setAdmissionStatus( entity.getAdmissionStatus() );
		return dto;
	}

	public List<PatientResponseDto> toList( List<Patient> content ) {
		List<PatientResponseDto> list = new ArrayList<>();
		for ( Patient dto : content )
			list.add( toDto( dto ) );
		return list;
	}
}
