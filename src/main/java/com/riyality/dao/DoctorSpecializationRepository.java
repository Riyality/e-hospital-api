package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.DoctorSpecialization;

@Repository
public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, Long> {
	@Override
	List<DoctorSpecialization> findAll();
}
