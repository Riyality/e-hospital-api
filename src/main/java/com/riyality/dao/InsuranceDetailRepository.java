package com.riyality.dao;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.InsuranceDetail;

public interface InsuranceDetailRepository extends CrudRepository<InsuranceDetail, Long> {

	InsuranceDetail findByPolicyNumber( String policyNumber );
}
