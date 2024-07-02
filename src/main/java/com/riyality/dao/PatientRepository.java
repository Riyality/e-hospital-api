package com.riyality.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Branch;
import com.riyality.entity.Patient;
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

	Page<Patient> findAllByBranch( Branch branch, Pageable pageable );

	List<Patient> findByBranchAndPhoneNumber( Branch branch, String phoneNumber );

	List<Patient> findByPhoneNumber(String phoneNumber);
}
