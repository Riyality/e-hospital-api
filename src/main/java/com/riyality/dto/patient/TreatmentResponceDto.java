package com.riyality.dto.patient;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class TreatmentResponceDto {
	private int treatment_id;
	private String medicine_type;
	private String medicine;
	private int quantity;
	private int price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate treatment_date;
	private String payment;
	private Long admission;
	
	
}
