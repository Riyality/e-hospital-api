package com.spti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.BranchDao;
import com.spti.dao.WardRepository;
import com.spti.dto.ward.WardRequestDto;
import com.spti.dto.ward.WardResponseDto;
import com.spti.entity.Branch;
import com.spti.entity.Ward;
import com.spti.mapper.ward.WardMapper;
import com.spti.service.WardService;

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
