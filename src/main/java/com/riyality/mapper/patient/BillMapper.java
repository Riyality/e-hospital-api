package com.riyality.mapper.patient;

import org.springframework.stereotype.Component;

import com.riyality.dto.patient.BillRequestDto;
import com.riyality.dto.patient.BillResponseDto;
import com.riyality.entity.Bill;

@Component
public class BillMapper {

	public Bill toEntity( BillRequestDto billRequestDto ) {
		Bill bill = new Bill();
		bill.setId( billRequestDto.getId() );
		bill.setAmount( billRequestDto.getAmount() );
		bill.setDiscount( billRequestDto.getDiscount() );
		bill.setFinalBill( billRequestDto.getFinalBill() );
		bill.setPaidAmount( billRequestDto.getPaidAmount() );
		bill.setPendingAmount( billRequestDto.getPendingAmount() );
		bill.setStatus( billRequestDto.getStatus() );
		//bill.setPatientAdmission( new PatientAdmission( billRequestDto.getAdmissionId() ) ); // Assuming PatientAdmission constructor with id
		return bill;
	}

	public BillResponseDto toDto( Bill bill ) {
		BillResponseDto billResponseDto = new BillResponseDto();
		billResponseDto.setId( bill.getId() );
		billResponseDto.setAmount( bill.getAmount() );
		billResponseDto.setDiscount( bill.getDiscount() );
		billResponseDto.setFinalBill( bill.getFinalBill() );
		billResponseDto.setPaidAmount( bill.getPaidAmount() );
		billResponseDto.setPendingAmount( bill.getPendingAmount() );
		billResponseDto.setStatus( bill.getStatus() );
		billResponseDto.setAdmissionId( bill.getPatientAdmission().getAdmissionId() );
		return billResponseDto;
	}

}
