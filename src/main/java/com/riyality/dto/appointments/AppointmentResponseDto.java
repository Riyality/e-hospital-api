package com.riyality.dto.appointments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {
	private Long id;
	private Long patientId;
	private Long doctorId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String status;
	private String notes;
	private int branch;
	private String phoneNumber;
	private String patientName;
	private String doctorName;
}
