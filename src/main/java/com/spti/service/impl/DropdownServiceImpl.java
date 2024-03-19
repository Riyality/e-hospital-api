package com.spti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.DoctorSpecializationRepository;
import com.spti.dao.MedicineTypeRepository;
import com.spti.dto.doctor.DoctorSpecializationDto;
import com.spti.dto.dropdowns.MedicineTypeDto;
import com.spti.dto.wrapper.DoctorSpecializationDtoWrapper;
import com.spti.entity.DoctorSpecialization;
import com.spti.entity.MedicineType;
import com.spti.mapper.DoctorSpecializationMapper;
import com.spti.mapper.dropdowns.MedicineTypeMapper;
import com.spti.service.DropdownService;

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
