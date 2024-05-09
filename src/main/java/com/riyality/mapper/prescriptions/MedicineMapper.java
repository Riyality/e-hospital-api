package com.riyality.mapper.prescriptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.prescriptions.MedicineRequestDto;
import com.riyality.dto.prescriptions.MedicineResponseDto;
import com.riyality.entity.Medicine;

@Component
public class MedicineMapper {

	public Medicine toEntity( MedicineRequestDto requestDto ) {
		Medicine entity = new Medicine();
		entity.setMedicineId( requestDto.getMedicineId() );
		entity.setMedicineName( requestDto.getMedicineName() );
		entity.setMedicineType( requestDto.getMedicineType() );
		entity.setDosage( requestDto.getDosage() );
		entity.setInstructions( requestDto.getInstructions() );
		entity.setNumDays( requestDto.getNumDays() );
		entity.setTabletQuantity( requestDto.getTabletQuantity() );
		return entity;
	}

	public MedicineResponseDto toDto( Medicine entity ) {
		MedicineResponseDto dto = new MedicineResponseDto();
		dto.setMedicineId( entity.getMedicineId() );
		dto.setPrescriptionId( entity.getPrescription().getPrescriptionId() );
		dto.setMedicineName( entity.getMedicineName() );
		dto.setMedicineType( entity.getMedicineType() );
		dto.setDosage( entity.getDosage() );
		dto.setInstructions( entity.getInstructions() );
		dto.setNumDays( entity.getNumDays() );
		dto.setTabletQuantity( entity.getTabletQuantity() );
		return dto;
	}

	public List<MedicineResponseDto> toList(List<Medicine> list) {
		
		List<MedicineResponseDto> dtoList = new ArrayList<>();
		for ( Medicine dto : list ) {
			dtoList.add( toDto( dto ) );
		}
		return dtoList;
	}
}
