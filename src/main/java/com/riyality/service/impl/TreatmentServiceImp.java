package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.PatientAdmissionRepository;
import com.riyality.dao.TreatmentRepository;
import com.riyality.dto.patient.TreatmentRequestDto;
import com.riyality.dto.patient.TreatmentResponceDto;
import com.riyality.entity.PatientAdmission;
import com.riyality.entity.Treatment;
import com.riyality.mapper.patient.TreatmentMapper;
import com.riyality.service.TreatmentService;

@Service
public class TreatmentServiceImp implements TreatmentService {
	
	@Autowired
	private TreatmentRepository repository;
	
	
	@Autowired
	private PatientAdmissionRepository patientdto;
	
	@Autowired
	private TreatmentMapper mapper;

	@Override
	public boolean addTreatment(List<TreatmentRequestDto> dto) {
		try {
			  
			for (TreatmentRequestDto dto1 : dto) {
		      Treatment treatment=mapper.addTreatment(dto1);
			Optional<PatientAdmission> opt=patientdto.findById(dto1.getAdmission());
			treatment.setAdmission(opt.get());
				repository.save(treatment);
			}
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TreatmentResponceDto> allTreatments(Long admission) {
		Optional<PatientAdmission> opt=patientdto.findById(admission);
		if(opt.isPresent()) {
			List<Treatment> treats=repository.findByAdmission(opt.get());
			return mapper.toList(treats);
		}
		return null;
	}

	
	

}
