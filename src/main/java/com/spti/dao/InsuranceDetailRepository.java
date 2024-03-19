package com.spti.dao;

import org.springframework.data.repository.CrudRepository;

import com.spti.entity.InsuranceDetail;

public interface InsuranceDetailRepository extends CrudRepository<InsuranceDetail, Long> {

	InsuranceDetail findByPolicyNumber( String policyNumber );
}
