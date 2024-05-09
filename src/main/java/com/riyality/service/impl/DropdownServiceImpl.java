package com.riyality.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.DoctorSpecializationRepository;
import com.riyality.dao.MedicineTypeRepository;
import com.riyality.dto.doctor.DoctorSpecializationDto;
import com.riyality.dto.dropdowns.MedicineTypeDto;
import com.riyality.dto.wrapper.DoctorSpecializationDtoWrapper;
import com.riyality.entity.DoctorSpecialization;
import com.riyality.entity.MedicineType;
import com.riyality.mapper.DoctorSpecializationMapper;
import com.riyality.mapper.dropdowns.MedicineTypeMapper;
import com.riyality.service.DropdownService;

@Service
public class DropdownServiceImpl implements DropdownService {

	@Autowired
	private DoctorSpecializationRepository doctorSpecializationRepository;

	@Autowired
	private DoctorSpecializationMapper doctorSpecializationMapper;

	@Autowired
	private MedicineTypeMapper medicineTypeMapper;

	@Autowired
	private MedicineTypeRepository medicineTypeRepository;

	@Override
	public boolean addSpecialization( DoctorSpecializationDtoWrapper wrapper ) {
		try {
			List<DoctorSpecializationDto> list = wrapper.getDoctorSpecializations();
			for ( DoctorSpecializationDto dto : list ) {
				DoctorSpecialization entity = doctorSpecializationMapper.toEntity( dto );
				doctorSpecializationRepository.save( entity );
			}
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DoctorSpecializationDto> getSpecialization() {
		List<DoctorSpecialization> entityList = doctorSpecializationRepository.findAll();
		return doctorSpecializationMapper.toList( entityList );
	}

	@Override
	public List<MedicineTypeDto> allMedicineTypes() {
		List<MedicineType> list = medicineTypeRepository.findAll();
		return medicineTypeMapper.toList( list );
	}

}
