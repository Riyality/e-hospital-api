package com.riyality.mapper.ward;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.ward.WardRequestDto;
import com.riyality.dto.ward.WardResponseDto;
import com.riyality.entity.Ward;

@Component
public class WardMapper {

	public Ward toEntity( WardRequestDto wardRequestDto ) {
		Ward ward = new Ward();
		ward.setId( wardRequestDto.getId() );
		ward.setWardName( wardRequestDto.getWardName() );
		ward.setMaxCapacity( wardRequestDto.getMaxCapacity() );
		ward.setCurrentOccupancy( wardRequestDto.getCurrentOccupancy() );
		ward.setFloorNumber( wardRequestDto.getFloorNumber() );
		ward.setWing( wardRequestDto.getWing() );
		ward.setStatus( wardRequestDto.getStatus() );
		ward.setCharges( wardRequestDto.getCharges() );
		return ward;
	}

	public WardResponseDto toDto( Ward ward ) {
		WardResponseDto wardResponseDto = new WardResponseDto();
		wardResponseDto.setId( ward.getId() );
		wardResponseDto.setWardName( ward.getWardName() );
		wardResponseDto.setMaxCapacity( ward.getMaxCapacity() );
		wardResponseDto.setCurrentOccupancy( ward.getCurrentOccupancy() );
		wardResponseDto.setFloorNumber( ward.getFloorNumber() );
		wardResponseDto.setWing( ward.getWing() );
		wardResponseDto.setStatus( ward.getStatus() );
		wardResponseDto.setBranch( ward.getBranch().getId() );
		wardResponseDto.setCharges( ward.getCharges() );
		return wardResponseDto;
	}

	public List<WardResponseDto> toList( List<Ward> list ) {
		List<WardResponseDto> dtoList = new ArrayList<>();
		for ( Ward dto : list ) {
			dtoList.add( toDto( dto ) );
		}
		return dtoList;
	}
}
