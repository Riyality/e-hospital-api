package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.CotRepository;
import com.riyality.dao.WardRepository;
import com.riyality.dto.cot.CotRequestDto;
import com.riyality.dto.cot.CotResponseDto;
import com.riyality.entity.Cot;
import com.riyality.entity.Ward;
import com.riyality.mapper.cot.CotMapper;
import com.riyality.service.CotService;

@Service
public class CotServiceImpl implements CotService {

	@Autowired
	private CotRepository cotRepository;

	@Autowired
	private CotMapper cotMapper;

	@Autowired
	private WardRepository wardRepository;

	@Override
	public boolean addCot( @Valid CotRequestDto dto ) {
		try {
			Cot entity = cotMapper.toEntity( dto );
			Optional<Ward> opt = wardRepository.findById( dto.getWardId() );
			if ( opt.isPresent() ) {
				Ward ward = opt.get();
				entity.setWard( ward );
				cotRepository.save( entity );
				int currentOccupancy = ward.getCurrentOccupancy();
				ward.setCurrentOccupancy( currentOccupancy + 1 );
				wardRepository.save( ward );
			}

			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CotResponseDto> availableCots( Long id ) {
		Optional<Ward> opt = wardRepository.findById( id );
		if ( opt.isPresent() ) {
			List<Cot> cots = cotRepository.findByWardAndStatus( opt.get(), "Vacant" );
			return cotMapper.toListDto( cots );
		}

		return null;
	}

	@Override
	public List<CotResponseDto> allCots( Long id ) {
		Optional<Ward> opt = wardRepository.findById( id );
		if ( opt.isPresent() ) {
			List<Cot> cots = cotRepository.findByWard( opt.get() );
			return cotMapper.toListDto( cots );
		}

		return null;
	}

}
