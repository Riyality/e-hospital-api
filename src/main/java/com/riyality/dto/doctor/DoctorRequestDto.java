package com.riyality.dto.doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequestDto {
	private Long id;
	@NotNull
    @Size(max = 16)
	private String firstName;
	@NotNull
    @Size(max = 16)
	private String lastName; 
	@Size(max = 32)
	private String specialization;
	@Size(max = 64)
	private String email;
	@Size(max = 10 , min=10)
	private String phoneNumber;
	@Size(max = 256)
	private String address;
	@Size(max = 16)
	private String experience;
	@Size(max = 16)
	private String status;
	private int branch;
	private Integer consultationFee;
	@Size(max = 32)
	private String availableDays;
	@Size(max = 32)
	private String availableTimeSlots;

	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private LocalDate joiningDate;
	@Size(max = 128)
	private String qualifications;
}
