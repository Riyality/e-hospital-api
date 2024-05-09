package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.BranchDao;
import com.riyality.dao.WardRepository;
import com.riyality.dto.ward.WardRequestDto;
import com.riyality.dto.ward.WardResponseDto;
import com.riyality.entity.Branch;
import com.riyality.entity.Ward;
import com.riyality.mapper.ward.WardMapper;
import com.riyality.service.WardService;

@Service
public class WardServiceImpl implements WardService {

	@Autowired
	private WardRepository wardRepository;

	@Autowired
	private WardMapper wardMapper;

	@Autowired
	private BranchDao branchDao;

	@Override
	public boolean addWard( WardRequestDto dto ) {
		try {
			Ward entity = wardMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranch() );
			if ( opt.isPresent() ) {
				entity.setBranch( opt.get() );
			}
			wardRepository.save( entity );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<WardResponseDto> allWards( int branchId ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			List<Ward> list = wardRepository.findByBranch( opt.get() );
			return wardMapper.toList( list );
		}
		return null;
	}

	@Override
	public WardResponseDto wardById( Long id ) {
		Optional<Ward> opt = wardRepository.findById( id );
		if ( opt.isPresent() ) {
			return wardMapper.toDto( opt.get() );
		}
		return null;
	}

	@Override
	public boolean updateWard( WardRequestDto dto ) {
		try {
			Ward ward = wardMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranch() );
			if ( opt.isPresent() ) {
				ward.setBranch( opt.get() );
			}
			wardRepository.save( ward );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<WardResponseDto> allAvailableWards( int branchId ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			List<Ward> list = wardRepository.findWardsWithCurrentOccupancyLessThanMaxCapacityAndBranch( opt.get() );
			return wardMapper.toList( list );
		}

		return null;
	}

}
