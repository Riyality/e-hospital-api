package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.PatientAdmission;
import com.riyality.entity.Treatment;

public interface TreatmentRepository extends CrudRepository<Treatment, Integer> {
   List<Treatment> findByAdmission(PatientAdmission admission);

}
