package com.riyality.dto.patient;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.riyality.dto.cot.CotResponseDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.dto.ward.WardResponseDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DischargeResponseDto {

	private Long admissionId;

	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime admissionDate;

	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime dischargeDate;
	private Long admittedDays;
	private float bill;

	private WardResponseDto ward;
	private CotResponseDto cot;
	private PatientResponseDto patient;
	private DoctorResponseDto doctor;

}
