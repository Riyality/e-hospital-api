package com.riyality.service;

import java.util.List;

import javax.validation.Valid;

import com.riyality.dto.cot.CotRequestDto;
import com.riyality.dto.cot.CotResponseDto;

public interface CotService {

	boolean addCot( @Valid CotRequestDto dto );

	List<CotResponseDto> availableCots( Long id );

	List<CotResponseDto> allCots( Long id );

}
