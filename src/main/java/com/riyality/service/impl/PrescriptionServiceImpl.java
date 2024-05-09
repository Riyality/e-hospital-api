package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.DoctorRepository;
import com.riyality.dao.MedicineRepository;
import com.riyality.dao.PatientRepository;
import com.riyality.dao.PrescriptionRepository;
import com.riyality.dto.prescriptions.MedicineRequestDto;
import com.riyality.dto.prescriptions.MedicineResponseDto;
import com.riyality.dto.prescriptions.PrescriptionRequestDto;
import com.riyality.dto.prescriptions.PrescriptionResponseDto;
import com.riyality.entity.Doctor;
import com.riyality.entity.Medicine;
import com.riyality.entity.Patient;
import com.riyality.entity.Prescription;
import com.riyality.mapper.prescriptions.MedicineMapper;
import com.riyality.mapper.prescriptions.PrescriptionMapper;
import com.riyality.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;

	@Autowired
	private MedicineRepository medicineRepository;

	@Autowired
	private PrescriptionMapper prescriptionMapper;

	@Autowired
	private MedicineMapper medicineMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public boolean addPrescription( PrescriptionRequestDto dto ) {
		try {
			Prescription prescription = prescriptionMapper.toEntity( dto );
			Optional<Patient> patient = patientRepository.findById( dto.getPatientId() );
			if ( patient.isPresent() )
				prescription.setPatient( patient.get() );
			Optional<Doctor> doctor = doctorRepository.findById( dto.getDoctorId() );
			if ( doctor.isPresent() )
				prescription.setDoctor( doctor.get() );
			Prescription prescriptionAdded = prescriptionRepository.save( prescription );
			for ( MedicineRequestDto medicineDto : dto.getMedicines() ) {
				Medicine medicine = medicineMapper.toEntity( medicineDto );
				medicine.setPrescription( prescriptionAdded );
				medicineRepository.save( medicine );
			}
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PrescriptionResponseDto> findAllPrescription( Long id ) {
		List<Prescription> prescriptions = prescriptionRepository.findAllByPatientId( id );
		return prescriptionMapper.toList( prescriptions );
	}

	@Override
	public List<MedicineResponseDto> findMedicineByPrescriptionId( Long prescriptionId ) {

		List<Medicine> medicines = medicineRepository.findByPrescriptionPrescriptionId( prescriptionId );
		return medicineMapper.toList( medicines );
	}

	@Override
	public List<PrescriptionResponseDto> findTopById( Long patientId ) {
		List<Prescription> prescriptions = prescriptionRepository.findByPatientIdOrderByPrescriptionIdDesc( patientId );
		return prescriptionMapper.toList( prescriptions );
	}
}
