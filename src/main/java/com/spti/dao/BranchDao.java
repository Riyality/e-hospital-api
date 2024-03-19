package com.spti.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spti.entity.Branch;

public interface BranchDao extends CrudRepository<Branch, Integer> {

	List<Branch> findAll();
}
