package com.riyality.dto.patient;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentRequestDto {
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
