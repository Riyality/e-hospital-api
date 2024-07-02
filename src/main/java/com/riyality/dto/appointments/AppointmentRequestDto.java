package com.riyality.dto.appointments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDto {
	private Long id;
	private Long patientId;
	private Long doctorId;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private LocalDate appointmentDate;

	@DateTimeFormat( pattern = "HH:mm" )
	private LocalTime appointmentTime;
	private String status;
	private String notes;
	private int branch;
	private String phoneNumber;
}
