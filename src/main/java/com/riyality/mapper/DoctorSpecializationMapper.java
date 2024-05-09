package com.riyality.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.riyality.dto.doctor.DoctorSpecializationDto;
import com.riyality.entity.DoctorSpecialization;

@Component
public class DoctorSpecializationMapper {

	public DoctorSpecializationDto toDto( DoctorSpecialization entity ) {
		DoctorSpecializationDto dto = new DoctorSpecializationDto();
		dto.setId( entity.getId() );
		dto.setTitle( entity.getTitle() );
		return dto;
	}

	public List<DoctorSpecializationDto> toList( List<DoctorSpecialization> entityList ) {
		return entityList.stream()
				.map( this::toDto )
				.collect( Collectors.toList() );
	}

	public DoctorSpecialization toEntity( DoctorSpecializationDto dto ) {
		DoctorSpecialization entity = new DoctorSpecialization();
		entity.setId( dto.getId() );
		entity.setTitle( dto.getTitle() );
		return entity;
	}
}
