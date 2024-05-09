package com.riyality.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.InsuranceDetailRepository;
import com.riyality.dto.insurance.InsuranceDetailRequestDto;
import com.riyality.dto.insurance.InsuranceDetailResponseDto;
import com.riyality.entity.InsuranceDetail;
import com.riyality.mapper.insurance.InsuranceDetailsMapper;
import com.riyality.service.InsuranceDetailService;

@Service
public class InsuranceDetailServiceImpl implements InsuranceDetailService {

	@Autowired
	private InsuranceDetailRepository insuranceDetailRepository;

	@Autowired
	private InsuranceDetailsMapper insuranceDetailsMapper;

	@Override
	public InsuranceDetailResponseDto addInsuranceDetail( InsuranceDetailRequestDto insuranceDetailRequestDto ) {
		try {
			InsuranceDetail entity = insuranceDetailsMapper.toEntity( insuranceDetailRequestDto );
			InsuranceDetail addedEntity = insuranceDetailRepository.save( entity );
			return insuranceDetailsMapper.toDto( addedEntity );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InsuranceDetailResponseDto getInsuranceDetailByPolicyNumber( String policyNumber ) {
		InsuranceDetail entity = insuranceDetailRepository.findByPolicyNumber( policyNumber );
		if ( entity != null ) {
			return insuranceDetailsMapper.toDto( entity );
		}
		return null;
	}

}
