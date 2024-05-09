package com.riyality.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.doctor.DoctorRequestDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.entity.Doctor;

@Component
public class DoctorMapper {

	public Doctor toEntity( DoctorRequestDto dto ) {
		Doctor doctor = new Doctor();
		doctor.setId( dto.getId() );
		doctor.setFirstName( dto.getFirstName() );
		doctor.setLastName( dto.getLastName() );
		doctor.setEmail( dto.getEmail() );
		doctor.setPhoneNumber( dto.getPhoneNumber() );
		doctor.setSpecialization( dto.getSpecialization() );
		doctor.setAddress( dto.getAddress() );
		doctor.setExperience( dto.getExperience() );
		doctor.setStatus( dto.getStatus() );
		doctor.setConsultationFee( dto.getConsultationFee() );
		doctor.setAvailableDays( dto.getAvailableDays() );
		doctor.setAvailableTimeSlots( dto.getAvailableTimeSlots() );
		doctor.setJoiningDate( dto.getJoiningDate() );
		doctor.setQualifications( dto.getQualifications() );
		return doctor;
	}

	public DoctorResponseDto toDto( Doctor doctor ) {
		DoctorResponseDto dto = new DoctorResponseDto();
		dto.setId( doctor.getId() );
		dto.setFirstName( doctor.getFirstName() );
		dto.setLastName( doctor.getLastName() );
		dto.setSpecialization( doctor.getSpecialization() );
		dto.setExperience( doctor.getExperience() );
		dto.setEmail( doctor.getEmail() );
		dto.setAddress( doctor.getAddress() );
		dto.setPhoneNumber( doctor.getPhoneNumber() );
		dto.setStatus( doctor.getStatus() );
		dto.setBranch( doctor.getBranch().getId() );
		dto.setConsultationFee( doctor.getConsultationFee() );
		dto.setAvailableDays( doctor.getAvailableDays() );
		dto.setAvailableTimeSlots( doctor.getAvailableTimeSlots() );
		dto.setJoiningDate( doctor.getJoiningDate() );
		dto.setQualifications( doctor.getQualifications() );
		return dto;
	}

	public List<DoctorResponseDto> toList( List<Doctor> list ) {
		List<DoctorResponseDto> dtoList = new ArrayList<>();
		for ( Doctor doctor : list ) {
			dtoList.add( toDto( doctor ) );
		}
		return dtoList;
	}
}
