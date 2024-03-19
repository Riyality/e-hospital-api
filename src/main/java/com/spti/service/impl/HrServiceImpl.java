package com.spti.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spti.dao.BranchDao;
import com.spti.dao.DoctorRepository;
import com.spti.dao.StaffRepository;
import com.spti.dto.LoginRequestDto;
import com.spti.dto.doctor.DoctorRequestDto;
import com.spti.dto.doctor.DoctorResponseDto;
import com.spti.dto.staff.StaffRequestDto;
import com.spti.dto.staff.StaffResponseDto;
import com.spti.entity.Branch;
import com.spti.entity.Doctor;
import com.spti.entity.Staff;
import com.spti.mapper.DoctorMapper;
import com.spti.mapper.staff.StaffMapper;
import com.spti.service.HrService;
import com.spti.service.LoginService;

@Service
public class HrServiceImpl implements HrService {

	private static final String PASSWORD = "Demo_1234";

	@Autowired
	private LoginService loginService;

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorMapper doctorMapper;

	@Autowired
	private StaffMapper staffMapper;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public boolean addDoctor( @Valid DoctorRequestDto doctorDto ) {
		try {
			Doctor doctor = doctorMapper.toEntity( doctorDto );
			Optional<Branch> opt = branchDao.findById( doctorDto.getBranch() );
			if ( opt.isPresent() ) {
				doctor.setBranch( opt.get() );
			}
			doctorRepository.save( doctor );
			LoginRequestDto dto = new LoginRequestDto( 0, doctorDto.getEmail(), PASSWORD, "Doctor" );
			loginService.add( dto );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Page<DoctorResponseDto> allDoctors( int branchId, Pageable pageable ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			Page<Doctor> entityPage = doctorRepository.findAllByBranch( opt.get(), pageable );
			return new PageImpl<>( doctorMapper.toList( entityPage.getContent() ), pageable, entityPage.getTotalElements() );
		}
		return null;
	}

	@Override
	public DoctorResponseDto getDoctorById( long id ) {
		Optional<Doctor> doctor = doctorRepository.findById( id );

		if ( doctor.isPresent() )
			return doctorMapper.toDto( doctor.get() );
		else
			return null;

	}

	@Override
	public boolean updateDoctor( @Valid DoctorRequestDto doctorDto ) {
		try {
			Doctor doctor = doctorMapper.toEntity( doctorDto );
			Optional<Branch> opt = branchDao.findById( doctorDto.getBranch() );
			if ( opt.isPresent() ) {
				doctor.setBranch( opt.get() );
			}
			doctorRepository.save( doctor );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DoctorResponseDto> allDoctorsList( int branchId ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			List<Doctor> list = doctorRepository.findByBranch( opt.get() );
			return doctorMapper.toList( list );
		}
		return null;

	}

	@Override
	public boolean addStaff( @Valid StaffRequestDto staffDto ) {
		try {
			Staff staff = staffMapper.toEntity( staffDto );
			Optional<Branch> opt = branchDao.findById( staffDto.getBranch() );
			if ( opt.isPresent() ) {

				staff.setBranch( opt.get() );
			}
			staffRepository.save( staff );
			LoginRequestDto dto = new LoginRequestDto( 0, staffDto.getEmail(), PASSWORD, staffDto.getRole() );
			loginService.add( dto );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<StaffResponseDto> allStaff( int branchId ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			List<Staff> staffs = staffRepository.findByBranch( opt.get() );
			return staffMapper.toList( staffs );
		}

		return null;
	}

	@Override
	public boolean updateStaff( @Valid StaffRequestDto dto ) {
		try {
			Staff staff = staffMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranch() );
			if ( opt.isPresent() ) {

				staff.setBranch( opt.get() );
			}
			staffRepository.save( staff );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public StaffResponseDto staffByID( Long id ) {
		Optional<Staff> staff = staffRepository.findById( id );
		if ( staff.isPresent() )
			return staffMapper.toDto( staff.get() );
		return null;
	}
}
