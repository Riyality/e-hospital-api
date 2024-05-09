package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Prescription;

@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {

	List<Prescription> findAllByPatientId( Long id );

	List<Prescription> findByPatientIdOrderByPrescriptionIdDesc( Long patientId );
}
