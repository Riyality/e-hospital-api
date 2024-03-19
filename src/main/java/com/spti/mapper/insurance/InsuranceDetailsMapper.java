package com.spti.mapper.insurance;

import org.springframework.stereotype.Component;

import com.spti.dto.insurance.InsuranceDetailRequestDto;
import com.spti.dto.insurance.InsuranceDetailResponseDto;
import com.spti.entity.InsuranceDetail;

@Component
public class InsuranceDetailsMapper {

	public InsuranceDetail toEntity( InsuranceDetailRequestDto dto ) {
		InsuranceDetail details = new InsuranceDetail();
		details.setId( dto.getId() );
		details.setPolicyNumber( dto.getPolicyNumber() );
		details.setProviderName( dto.getProviderName() );
		details.setExpiryDate( dto.getExpiryDate() );

		return details;
	}

	public InsuranceDetailResponseDto toDto( InsuranceDetail entity ) {
		InsuranceDetailResponseDto dto = new InsuranceDetailResponseDto();

		dto.setId( entity.getId() );
		dto.setPolicyNumber( entity.getPolicyNumber() );
		dto.setProviderName( entity.getProviderName() );
		dto.setExpiryDate( entity.getExpiryDate() );

		return dto;
	}
}
