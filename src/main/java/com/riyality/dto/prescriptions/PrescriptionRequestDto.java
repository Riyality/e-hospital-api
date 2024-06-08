package com.riyality.dto.prescriptions;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRequestDto {
	private Long prescriptionId;
	private Long patientId;
	private Long doctorId;
	private LocalDate prescriptionDate;
	private String prescription;
	private List<MedicineRequestDto> medicines;
	private String diagnosis;
}
