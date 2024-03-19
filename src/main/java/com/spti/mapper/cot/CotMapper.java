package com.spti.mapper.cot;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spti.dto.cot.CotRequestDto;
import com.spti.dto.cot.CotResponseDto;
import com.spti.entity.Cot;

@Component
public class CotMapper {

	public Cot toEntity( CotRequestDto cotRequestDto ) {
		Cot cot = new Cot();
		cot.setCotNumber( cotRequestDto.getCotNumber() );
		cot.setStatus( cotRequestDto.getStatus() );
		return cot;
	}

	public CotResponseDto toDto( Cot cot ) {
		CotResponseDto cotResponseDto = new CotResponseDto();
		cotResponseDto.setId( cot.getCotId() );
		cotResponseDto.setCotNumber( cot.getCotNumber() );
		cotResponseDto.setWardId( cot.getWard().getId() ); // Assuming you want to include wardId in the response
		cotResponseDto.setStatus( cot.getStatus() );
		return cotResponseDto;
	}

	public List<CotResponseDto> toListDto( List<Cot> cots ) {
		return cots.stream()
				.map( this::toDto )
				.collect( Collectors.toList() );
	}
}
