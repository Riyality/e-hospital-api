package com.riyality.mapper.staff;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import com.riyality.dto.staff.StaffRequestDto;
import com.riyality.dto.staff.StaffResponseDto;
import com.riyality.entity.Staff;

@Controller
public class StaffMapper {

	public Staff toEntity( @Valid StaffRequestDto staffDto ) {
		Staff entity = new Staff();

		entity.setId( staffDto.getId() );
		entity.setFirstName( staffDto.getFirstName() );
		entity.setLastName( staffDto.getLastName() );
		entity.setRole( staffDto.getRole() );
		entity.setEmail( staffDto.getEmail() );
		entity.setPhoneNumber( staffDto.getPhoneNumber() );
		entity.setAddress( staffDto.getAddress() );
		entity.setExperience( staffDto.getExperience() );
		entity.setStatus( staffDto.getStatus() );
		return entity;

	}

	public StaffResponseDto toDto( Staff staff ) {
		StaffResponseDto dto = new StaffResponseDto();
		dto.setId( staff.getId() );
		dto.setFirstName( staff.getFirstName() );
		dto.setLastName( staff.getLastName() );
		dto.setRole( staff.getRole() );
		dto.setEmail( staff.getEmail() );
		dto.setPhoneNumber( staff.getPhoneNumber() );
		dto.setAddress( staff.getAddress() );
		dto.setExperience( staff.getExperience() );
		dto.setStatus( staff.getStatus() );
		if ( staff.getBranch() != null ) {
			dto.setBranch( staff.getBranch().getId() );
		}
		return dto;
	}

	public List<StaffResponseDto> toList( List<Staff> staffs ) {
		List<StaffResponseDto> dtoList = new ArrayList<>();
		for ( Staff staff : staffs ) {
			dtoList.add( toDto( staff ) );
		}
		return dtoList;
	}

}
