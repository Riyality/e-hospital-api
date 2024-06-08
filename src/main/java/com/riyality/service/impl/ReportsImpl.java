package com.riyality.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.PatientAdmissionRepository;
import com.riyality.dao.ReportsRepository;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;
import com.riyality.mapper.patient.PatientMapper;
import com.riyality.service.ReportsService;

@Service
public class ReportsImpl implements ReportsService{
	@Autowired
	ReportsRepository reportsRepository;
	@Autowired
	private PatientMapper patientMapper;
	@Autowired
	private PatientAdmissionRepository admissionRepository;


	@Override
	public List<PatientResponseDto> reportsPatients(String type, String user) {
		List<Patient> patient= (List<Patient>) reportsRepository.findAll();
		
		List<PatientResponseDto> a=patientMapper.toList(patient);
		return a;
		
	}
	@Override
	public List<PatientResponseDto> findAllAdmittedPatients(String type ) {
		 
            LocalDate now = LocalDate.now();
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String formattedDateTime = now.format(formatter);
        
		
		
		if(type.equals("all"))
		{
		List<PatientAdmission> admissions = admissionRepository.findAllByAdmissionStatus( "Admitted" );
		List<Patient> patients = admissions.stream().map( admission -> admission.getPatient() ).collect( Collectors.toList() );
		System.out.println(admissions);
		return patientMapper.toList( patients );
		}
		if(type.equals("todays"))
		{
			System.out.println("********************************************************************");
			List<PatientAdmission> admissions = admissionRepository.findAllByAdmissionStatusAndAdmissionDate( "Admitted",now );
			List<Patient> patients = admissions.stream().map( admission -> admission.getPatient() ).collect( Collectors.toList() );
			 List<PatientResponseDto> b= patientMapper.toList( patients );
			  return b;
			
		}
		return null;
	}
	
	
	

}
