package com.spti.mapper.dropdowns;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spti.dto.dropdowns.MedicineTypeDto;
import com.spti.entity.MedicineType;

@Component
public class MedicineTypeMapper {
	public static MedicineTypeDto toDto( MedicineType medicineType ) {
		MedicineTypeDto dto = new MedicineTypeDto();
		dto.setId( medicineType.getId() );
		dto.setType( medicineType.getType() );
		return dto;
	}

	public static MedicineType toEntity( MedicineTypeDto medicineTypeDto ) {
		MedicineType entity = new MedicineType();
		entity.setId( medicineTypeDto.getId() );
		entity.setType( medicineTypeDto.getType() );
		return entity;
	}

	public List<MedicineTypeDto> toList( List<MedicineType> list ) {
		List<MedicineTypeDto> dtoList = new ArrayList<>();
		for ( MedicineType medicineType : list ) {
			MedicineTypeDto dto = toDto( medicineType );
			dtoList.add( dto );
		}
		return dtoList;
	}
}
