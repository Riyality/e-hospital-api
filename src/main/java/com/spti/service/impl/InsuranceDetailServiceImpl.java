package com.spti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.InsuranceDetailRepository;
import com.spti.dto.insurance.InsuranceDetailRequestDto;
import com.spti.dto.insurance.InsuranceDetailResponseDto;
import com.spti.entity.InsuranceDetail;
import com.spti.mapper.insurance.InsuranceDetailsMapper;
import com.spti.service.InsuranceDetailService;

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
