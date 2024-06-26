package com.riyality.dto.prescriptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionResponseDto {
	private Long prescriptionId;
	private Long patientId;
	private String diagnosis;
	private Long doctorId;
	private String doctorName;
	private LocalDate prescriptionDate;
	private String prescription;
}
