package com.riyality.mapper.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riyality.dto.patient.TreatmentRequestDto;
import com.riyality.dto.patient.TreatmentResponceDto;
import com.riyality.entity.Treatment;

@Component
public class TreatmentMapper {
	
	public Treatment addTreatment(TreatmentRequestDto dto) {
		Treatment treatment=new Treatment();
		treatment.setMedicine_type(dto.getMedicine_type());
		treatment.setMedicine(dto.getMedicine());
		treatment.setQuantity(dto.getQuantity());
		treatment.setPrice(dto.getPrice());
		treatment.setTreatment_date(dto.getTreatment_date());
		treatment.setPayment(dto.getPayment());
		return treatment;
	}
	
	public TreatmentResponceDto toDto(Treatment treatment) {
	     TreatmentResponceDto responce=new TreatmentResponceDto();
	     responce.setTreatment_id(treatment.getTreatment_id());
	     responce.setMedicine_type(treatment.getMedicine_type());
	     responce.setMedicine(treatment.getMedicine());
	     responce.setQuantity(treatment.getQuantity());
	     responce.setPrice(treatment.getPrice());
	     responce.setTreatment_date(treatment.getTreatment_date());
	     responce.setPayment(treatment.getPayment());
	     if(treatment.getAdmission()!=null) {
	    	 responce.setAdmission(treatment.getAdmission().getAdmissionId());
	     }
	     return responce;
	}
	
	public List<TreatmentResponceDto> toList(List<Treatment> treatment){
		List<TreatmentResponceDto> dtoList=new ArrayList<TreatmentResponceDto>();
		for(Treatment treats:treatment) {
			dtoList.add(toDto(treats));
		}
		return dtoList;
	}

}
