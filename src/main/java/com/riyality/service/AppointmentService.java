package com.riyality.service;

import java.util.List;

import javax.validation.Valid;

import com.riyality.dto.appointments.AppointmentRequestDto;
import com.riyality.dto.appointments.AppointmentResponseDto;

public interface AppointmentService {

	boolean addAppointment( AppointmentRequestDto dto );

	List<AppointmentResponseDto> getTodaysAppointments( int branchId );

	AppointmentResponseDto getAppointmentById( Long id );

	boolean updateAppointment( @Valid AppointmentRequestDto dto );

	List<AppointmentResponseDto> getTodaysAppointmentsForADoctor( Long doctorId, int branchId );

}
