package com.spti.service;

import com.spti.dto.insurance.InsuranceDetailRequestDto;
import com.spti.dto.insurance.InsuranceDetailResponseDto;

public interface InsuranceDetailService {

	public InsuranceDetailResponseDto addInsuranceDetail( InsuranceDetailRequestDto insuranceDetailRequestDto );

	public InsuranceDetailResponseDto getInsuranceDetailByPolicyNumber( String policyNumber );
}
