package com.riyality.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BillResponseDto {
	private Long id;
	private Long admissionId;
	private Integer amount;
	private Integer discount;
	private Integer finalBill;
	private Integer paidAmount;
	private Integer pendingAmount;
	private String status;
}
