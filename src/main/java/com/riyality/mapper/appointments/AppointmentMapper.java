package com.riyality.mapper.appointments;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.riyality.dto.appointments.AppointmentRequestDto;
import com.riyality.dto.appointments.AppointmentResponseDto;
import com.riyality.entity.Appointment;

@Component
public class AppointmentMapper {

	public Appointment toEntity( AppointmentRequestDto requestDto ) {
		Appointment entity = new Appointment();
		entity.setAppointmentId( requestDto.getId() );
		entity.setAppointmentDate( requestDto.getAppointmentDate() );
		entity.setAppointmentTime( requestDto.getAppointmentTime() );
		entity.setStatus( requestDto.getStatus() );
		entity.setNotes( requestDto.getNotes() );
		entity.setPhoneNumber( requestDto.getPhoneNumber() );
		return entity;
	}

	public AppointmentResponseDto toDto( Appointment entity ) {
		AppointmentResponseDto dto = new AppointmentResponseDto();
		dto.setId( entity.getAppointmentId() );
		dto.setPatientId( entity.getPatient().getId() );
		dto.setDoctorId( entity.getDoctor().getId() );
		dto.setAppointmentDate( entity.getAppointmentDate() );
		dto.setAppointmentTime( entity.getAppointmentTime() );
		dto.setStatus( entity.getStatus() );
		dto.setNotes( entity.getNotes() );
		dto.setBranch( entity.getBranch().getId() );
		dto.setPhoneNumber( entity.getPhoneNumber() );
		return dto;
	}

	public List<AppointmentResponseDto> toList( List<Appointment> list ) {
		return list.stream().map( this::toDto ).collect( Collectors.toList() );
	}
}
