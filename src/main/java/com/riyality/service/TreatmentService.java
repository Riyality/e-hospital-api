package com.riyality.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.riyality.dto.patient.TreatmentRequestDto;
import com.riyality.dto.patient.TreatmentResponceDto;

@Service
public interface TreatmentService {
   
	boolean addTreatment(List<TreatmentRequestDto> dto);
	public List<TreatmentResponceDto> allTreatments(Long admission);
	
}
