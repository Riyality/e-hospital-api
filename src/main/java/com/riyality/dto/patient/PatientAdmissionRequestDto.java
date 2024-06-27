package com.riyality.dto.patient;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionRequestDto {

	private Long admissionId;
	private Long patientId;
	private Long wardId;
	private Long cotId;
	
	private LocalDate admissionDate;

	private LocalDate dischargeDate;
	private Long doctorId;
	private String nextOfKinName;
	private String nextOfKinRelationship;
	private String nextOfKinPhoneNumber;
	private int branchId;
	private String admissionStatus;
	//private String diagnosis;

}
