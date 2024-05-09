package com.riyality.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riyality.dao.BranchDao;
import com.riyality.dao.DoctorRepository;
import com.riyality.dao.InsuranceDetailRepository;
import com.riyality.dao.PatientRepository;
import com.riyality.dto.appointments.AppointmentRequestDto;
import com.riyality.dto.patient.PatientRequestDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Branch;
import com.riyality.entity.Doctor;
import com.riyality.entity.InsuranceDetail;
import com.riyality.entity.Patient;
import com.riyality.mapper.insurance.InsuranceDetailsMapper;
import com.riyality.mapper.patient.PatientMapper;
import com.riyality.service.AppointmentService;
import com.riyality.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private InsuranceDetailRepository insuranceDetailRepository;

	@Autowired
	private InsuranceDetailsMapper insuranceDetailsMapper;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Page<PatientResponseDto> getAllPatients( int branchId, Pageable pageable ) {
		Optional<Branch> opt = branchDao.findById( branchId );
		if ( opt.isPresent() ) {
			Page<Patient> entityPage = patientRepository.findAllByBranch( opt.get(), pageable );
			return new PageImpl<>( patientMapper.toList( entityPage.getContent() ), pageable, entityPage.getTotalElements() );
		}
		return null;
	}

	@Override
	public PatientResponseDto getPatientById( Long id ) {
		Optional<Patient> patientOpt = patientRepository.findById( id );
		if ( patientOpt.isPresent() ) {
			PatientResponseDto res = patientMapper.toDto( patientOpt.get() );
			if ( res.getInsuranceId() != null ) {
				Optional<InsuranceDetail> insurance = insuranceDetailRepository.findById( res.getInsuranceId() );
				if ( insurance.isPresent() ) {
					res.setInsurance( insuranceDetailsMapper.toDto( insurance.get() ) );
				}
			}
			return res;
		}
		return null;
	}

	@Override
	public boolean addPatient( PatientRequestDto patientRequestDto ) {
		try {
			Patient patient = patientMapper.toEntity( patientRequestDto );
			patient.setAdmissionStatus( "OPD" );
			Optional<Branch> opt = branchDao.findById( patientRequestDto.getBranch() );
			if ( opt.isPresent() ) {
				patient.setBranch( opt.get() );
			}
			if ( patientRequestDto.getInsuranceId() != null ) {
				Optional<InsuranceDetail> insuranceOpt = insuranceDetailRepository.findById( patientRequestDto.getInsuranceId() );
				if ( insuranceOpt.isPresent() ) {
					patient.setInsuranceDetail( insuranceOpt.get() );
				}
			}
			if ( patientRequestDto.getDoctorId() != null ) {
				Optional<Doctor> doctorOpt = doctorRepository.findById( patientRequestDto.getDoctorId() );
				if ( doctorOpt.isPresent() ) {
					patient.setDoctor( doctorOpt.get() );
				}
			}
			Patient addedPatient = patientRepository.save( patient );
			AppointmentRequestDto dto = new AppointmentRequestDto();
			dto.setPatientId( addedPatient.getId() );
			dto.setAppointmentDate( LocalDateTime.now() );
			if ( opt.isPresent() )
				dto.setBranch( opt.get().getId() );
			dto.setStatus( "Confirmed" );
			dto.setNotes( "" );
			if ( addedPatient.getDoctor() != null )
				dto.setDoctorId( addedPatient.getDoctor().getId() );
			dto.setPhoneNumber( addedPatient.getPhoneNumber() );
			dto.setAppointmentTime( LocalTime.now() );
			appointmentService.addAppointment( dto );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePatient( PatientRequestDto patientRequestDto ) {
		try {
			Patient patient = patientMapper.toEntity( patientRequestDto );
			Optional<Branch> opt = branchDao.findById( patientRequestDto.getBranch() );
			if ( opt.isPresent() ) {
				patient.setBranch( opt.get() );
			}
			if ( patientRequestDto.getInsuranceId() != null ) {
				Optional<InsuranceDetail> insuranceDetailOpt = insuranceDetailRepository.findById( patientRequestDto.getInsuranceId() );
				if ( insuranceDetailOpt.isPresent() ) {
					patient.setInsuranceDetail( insuranceDetailOpt.get() );
				}
			}
			patientRepository.save( patient );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deletePatient( Long id ) {
	}

	@Override
	public List<PatientResponseDto> findPatientsByPhoneNumber( int branchId, String phoneNumber ) {
		try {
			Optional<Branch> opt = branchDao.findById( branchId );
			if ( opt.isPresent() ) {
				List<Patient> patients = patientRepository.findByBranchAndPhoneNumber( opt.get(), phoneNumber );
				return patientMapper.toList( patients );
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

}
