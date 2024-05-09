package com.riyality.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riyality.dao.BranchDao;
import com.riyality.dao.DoctorRepository;
import com.riyality.dao.StaffRepository;
import com.riyality.dto.LoginRequestDto;
import com.riyality.dto.doctor.DoctorRequestDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.dto.staff.StaffRequestDto;
import com.riyality.dto.staff.StaffResponseDto;
import com.riyality.entity.Branch;
import com.riyality.entity.Doctor;
import com.riyality.entity.Staff;
import com.riyality.mapper.DoctorMapper;
import com.riyality.mapper.staff.StaffMapper;
import com.riyality.service.HrService;
import com.riyality.service.LoginService;

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
