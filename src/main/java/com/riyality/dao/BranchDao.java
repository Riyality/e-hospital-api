package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.Branch;

public interface BranchDao extends CrudRepository<Branch, Integer> {

	List<Branch> findAll();
}
