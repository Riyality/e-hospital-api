package com.riyality.service;

import com.riyality.dto.insurance.InsuranceDetailRequestDto;
import com.riyality.dto.insurance.InsuranceDetailResponseDto;

public interface InsuranceDetailService {

	public InsuranceDetailResponseDto addInsuranceDetail( InsuranceDetailRequestDto insuranceDetailRequestDto );

	public InsuranceDetailResponseDto getInsuranceDetailByPolicyNumber( String policyNumber );
}
