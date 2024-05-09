package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.Branch;
import com.riyality.entity.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {

	Staff findByEmail( String username );

	List<Staff> findByBranch( Branch branch );

}
