package com.riyality.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.PatientAdmissionRepository;
import com.riyality.dao.PatientRepository;
import com.riyality.dao.ReportsRepository;
import com.riyality.dto.patient.PatientAdmissionResponseDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;
import com.riyality.mapper.patient.PatientAdmissionMapper;
import com.riyality.mapper.patient.PatientMapper;
import com.riyality.service.ReportsService;

@Service
public class ReportsImpl implements ReportsService {
	@Autowired
	ReportsRepository reportsRepository;
	@Autowired
	private PatientMapper patientMapper;
	@Autowired
	private PatientAdmissionRepository admissionRepository;
	@Autowired
	private PatientAdmissionMapper admissionMapper;

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public List<PatientResponseDto> reportsPatients(String type, String user) {
		List<Patient> patient = (List<Patient>) reportsRepository.findAll();

		List<PatientResponseDto> a = patientMapper.toList(patient);
		return a;

	}

	@Override
	public List<PatientAdmissionResponseDto> findAllAdmittedPatients(String type) {

		LocalDate now = LocalDate.now();

		if (type.equals("all")) {
			List<PatientAdmission> admissions = admissionRepository.findAllByAdmissionStatus("Admitted");
			List<PatientAdmissionResponseDto> list = admissionMapper.toList(admissions);
			for (PatientAdmissionResponseDto dto : list) {
				Patient patient = patientRepo.findById(dto.getPatientId()).get();
				dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
				dto.setContact(patient.getPhoneNumber());
			}
			return list;
		}
		if (type.equals("todays")) {
			List<PatientAdmission> admissions = admissionRepository.findAllByAdmissionStatusAndAdmissionDate("Admitted",
					now);
			List<PatientAdmissionResponseDto> list = admissionMapper.toList(admissions);
			for (PatientAdmissionResponseDto dto : list) {
				Patient patient = patientRepo.findById(dto.getPatientId()).get();
				dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
				dto.setContact(patient.getPhoneNumber());
			}
			return list;

		}
		if (type.equals("weekly")) {
			LocalDate oneWeekAgo = now.minusDays(7);

			List<PatientAdmission> admissions = admissionRepository
					.findByAdmissionStatusAndAdmissionDateBetween("Admitted", oneWeekAgo, now);
			List<PatientAdmissionResponseDto> list = admissionMapper.toList(admissions);
			for (PatientAdmissionResponseDto dto : list) {
				Patient patient = patientRepo.findById(dto.getPatientId()).get();
				dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
				dto.setContact(patient.getPhoneNumber());
			}
			return list;

		}
		if (type.equals("monthly")) {
			LocalDate oneWeekAgo = now.minusDays(30);

			List<PatientAdmission> admissions = admissionRepository
					.findByAdmissionStatusAndAdmissionDateBetween("Admitted", oneWeekAgo, now);
			List<PatientAdmissionResponseDto> list = admissionMapper.toList(admissions);
			for (PatientAdmissionResponseDto dto : list) {
				Patient patient = patientRepo.findById(dto.getPatientId()).get();
				dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
				dto.setContact(patient.getPhoneNumber());
			}
			return list;
		}
		if (type.equals("yearly")) {
			LocalDate oneWeekAgo = now.minusDays(365);

			List<PatientAdmission> admissions = admissionRepository
					.findByAdmissionStatusAndAdmissionDateBetween("Admitted", oneWeekAgo, now);
			List<PatientAdmissionResponseDto> list = admissionMapper.toList(admissions);
			for (PatientAdmissionResponseDto dto : list) {
				Patient patient = patientRepo.findById(dto.getPatientId()).get();
				dto.setPatientName(patient.getFirstName() + " " + patient.getLastName());
				dto.setContact(patient.getPhoneNumber());
			}
			return list;

		}
		return null;
	}

}
