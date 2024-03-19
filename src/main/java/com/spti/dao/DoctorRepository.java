package com.spti.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.spti.entity.Branch;
import com.spti.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	Page<Doctor> findAllByBranch( Branch branch, Pageable pageable );

	//List<Doctor> findByBranch( int branchId );

	List<Doctor> findByBranch( Branch branch );

	Doctor findByEmail( String username );
}
