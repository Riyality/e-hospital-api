package com.riyality.dto.prescriptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineResponseDto {
	private Long medicineId;
	private Long prescriptionId;
	private String medicineName;
	private String medicineType;
	private String dosage;
	private String instructions;
	private Integer numDays;
	private Integer tabletQuantity;
}
