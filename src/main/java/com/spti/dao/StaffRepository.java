package com.spti.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spti.entity.Branch;
import com.spti.entity.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {

	Staff findByEmail( String username );

	List<Staff> findByBranch( Branch branch );

}
