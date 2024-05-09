package com.riyality.service;

import java.util.List;

import com.riyality.dto.BranchRequestDto;
import com.riyality.dto.BranchResponceDto;

public interface BranchService {

	BranchRequestDto getById( int id );
	
	boolean add(BranchRequestDto branchDto);

	List<BranchResponceDto> all();
}
