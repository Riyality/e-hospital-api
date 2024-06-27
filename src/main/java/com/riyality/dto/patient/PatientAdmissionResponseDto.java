package com.riyality.dto.patient;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionResponseDto {

	private Long admissionId;
	private Long patientId;
	private Long wardId;
	private Long cotId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate admissionDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dischargeDate;
	private Long doctorId;
	private String doctorName;
	private String nextOfKinName;
	private String nextOfKinRelationship;
	private String nextOfKinPhoneNumber;
	private int branchId;
	private String admissionStatus;
	private String diagnosis;
	private String patientName;
	private String contact;
	

}
