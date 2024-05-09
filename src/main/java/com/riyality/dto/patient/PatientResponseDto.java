package com.riyality.dto.patient;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.riyality.dto.insurance.InsuranceDetailResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String phoneNumber;
	private String email;
	private String emergencyContactName;
	private String emergencyContactNumber;
	private String bloodType;
	private String allergies;
	private String medicalHistory;
	private String occupation;
	private String maritalStatus;
	private String nationality;
	private String languageSpoken;
	private String religion;
	private String preferredDoctor;
	private InsuranceDetailResponseDto insurance;
	private Long insuranceId;
	private int branch;
	private Long doctorId;

	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime dateOfBirth;
	private String admissionStatus;
}
