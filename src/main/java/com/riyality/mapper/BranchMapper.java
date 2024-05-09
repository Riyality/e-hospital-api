package com.riyality.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.BranchRequestDto;
import com.riyality.dto.BranchResponceDto;
import com.riyality.entity.Branch;

@Component
public class BranchMapper {

	public Branch toEntity(BranchRequestDto branchDto) {

		Branch branch= new Branch();
		branch.setId(branchDto.getId());
		branch.setName(branchDto.getName());
		branch.setAddress(branchDto.getAddress());
		return  branch;

	}

	public List<BranchResponceDto> toListDto(List<Branch> list) {

		List<BranchResponceDto> listDto= new ArrayList<>();
		for(Branch branch:list)
		{
			BranchResponceDto respDto=new BranchResponceDto();
			respDto.setId(branch.getId());
			respDto.setName(branch.getName());
			respDto.setAddress(branch.getAddress());
			listDto.add(respDto);
		}

		return listDto;
	}

}