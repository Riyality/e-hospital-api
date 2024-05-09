package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;

@Repository
public interface PatientAdmissionRepository extends CrudRepository<PatientAdmission, Long> {

	PatientAdmission findByPatientAndAdmissionStatus( Patient patient, String string );

	List<PatientAdmission> findAllByAdmissionStatus( String string );

}
