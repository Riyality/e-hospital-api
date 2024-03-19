package com.spti.service;

import java.util.List;

import com.spti.dto.ward.WardRequestDto;
import com.spti.dto.ward.WardResponseDto;

public interface WardService {

	boolean addWard( WardRequestDto dto );

	List<WardResponseDto> allWards( int branchId );

	WardResponseDto wardById( Long id );

	boolean updateWard( WardRequestDto dto );

	List<WardResponseDto> allAvailableWards( int branchId );

}
