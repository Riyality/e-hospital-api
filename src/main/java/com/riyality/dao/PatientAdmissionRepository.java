package com.riyality.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;

@Repository
public interface PatientAdmissionRepository extends CrudRepository<PatientAdmission, Long> {

	PatientAdmission findByPatientAndAdmissionStatus( Patient patient, String string );

	List<PatientAdmission> findAllByAdmissionStatus( String string );

	List<PatientAdmission> findAllByAdmissionStatusAndAdmissionDate(String string, LocalDate todayDate);

	List<PatientAdmission> findByAdmissionStatusAndAdmissionDateBetween(String string, LocalDate oneWeekAgo, LocalDate now);

	List<PatientAdmission> findByPatientId(Long id);

}
