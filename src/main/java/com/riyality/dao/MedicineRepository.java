package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Medicine;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
	
    List<Medicine> findByPrescriptionPrescriptionId(Long prescriptionId);
}
