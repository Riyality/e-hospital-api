package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.BranchDao;
import com.riyality.dto.BranchRequestDto;
import com.riyality.dto.BranchResponceDto;
import com.riyality.entity.Branch;
import com.riyality.mapper.BranchMapper;
import com.riyality.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private BranchMapper branchMapper;

	@Override
	public BranchRequestDto getById( int id ) {
		Optional<Branch> opt = branchDao.findById( id );
		if ( opt.isPresent() ) {
			Branch branch = opt.get();
			return new BranchRequestDto( branch.getId(), branch.getName(), branch.getAddress() );
		}
		return null;
	}

	@Override
	public boolean add(BranchRequestDto branchDto) {

		try {
			Branch branch=branchMapper.toEntity(branchDto);
			branchDao.save(branch);
               return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BranchResponceDto> all() {
	     return branchMapper.toListDto(branchDao.findAll());  		
	}


}
