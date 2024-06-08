package com.riyality.dto.patient;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.riyality.dto.cot.CotResponseDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.dto.ward.WardResponseDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DischargeResponseDto {

	private Long admissionId;

	
	private LocalDate admissionDate;

	
	private LocalDate dischargeDate;
	private Long admittedDays;
	private float bill;

	private WardResponseDto ward;
	private CotResponseDto cot;
	private PatientResponseDto patient;
	private DoctorResponseDto doctor;

}
