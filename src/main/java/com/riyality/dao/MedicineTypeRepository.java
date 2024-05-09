package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.MedicineType;

@Repository
public interface MedicineTypeRepository extends CrudRepository<MedicineType, Integer> {

	@Override
	List<MedicineType> findAll();

}
