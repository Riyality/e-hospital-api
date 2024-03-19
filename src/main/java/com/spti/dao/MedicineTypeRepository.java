package com.spti.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spti.entity.MedicineType;

@Repository
public interface MedicineTypeRepository extends CrudRepository<MedicineType, Integer> {

	@Override
	List<MedicineType> findAll();

}
