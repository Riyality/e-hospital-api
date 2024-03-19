package com.spti.service;

import java.util.List;

import javax.validation.Valid;

import com.spti.dto.cot.CotRequestDto;
import com.spti.dto.cot.CotResponseDto;

public interface CotService {

	boolean addCot( @Valid CotRequestDto dto );

	List<CotResponseDto> availableCots( Long id );

	List<CotResponseDto> allCots( Long id );

}
