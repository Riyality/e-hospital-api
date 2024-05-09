package com.riyality.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riyality.dto.doctor.DoctorRequestDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.dto.staff.StaffRequestDto;
import com.riyality.dto.staff.StaffResponseDto;

public interface HrService {

	public Page<DoctorResponseDto> allDoctors( int branchId, Pageable pageable );

	public DoctorResponseDto getDoctorById( long id );

	public boolean updateDoctor( @Valid DoctorRequestDto doctorDto );

	public List<DoctorResponseDto> allDoctorsList( int branchId );

	public boolean addDoctor( @Valid DoctorRequestDto doctorDto );

	public boolean addStaff( @Valid StaffRequestDto staffDto );

	public List<StaffResponseDto> allStaff( int branchId );

	public boolean updateStaff( @Valid StaffRequestDto dto );

	public StaffResponseDto staffByID( Long id );

}
