package com.riyality.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dao.AppointmentRepository;
import com.riyality.dao.BranchDao;
import com.riyality.dao.DoctorRepository;
import com.riyality.dao.PatientRepository;
import com.riyality.dto.appointments.AppointmentRequestDto;
import com.riyality.dto.appointments.AppointmentResponseDto;
import com.riyality.entity.Appointment;
import com.riyality.entity.Branch;
import com.riyality.entity.Doctor;
import com.riyality.entity.Patient;
import com.riyality.mapper.appointments.AppointmentMapper;
import com.riyality.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private AppointmentMapper appointmentMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public boolean addAppointment( AppointmentRequestDto dto ) {

		try {
			Appointment entity = appointmentMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranch() );
			if ( opt.isPresent() ) {
				entity.setBranch( opt.get() );
			}
			Optional<Doctor> doctorOpt = doctorRepository.findById( dto.getDoctorId() );
			if ( doctorOpt.isPresent() ) {
				entity.setDoctor( doctorOpt.get() );
			}

			Optional<Patient> patientOpt = patientRepository.findById( dto.getPatientId() );
			if ( patientOpt.isPresent() ) {
				entity.setPatient( patientOpt.get() );
			}
			appointmentRepository.save( entity );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AppointmentResponseDto> getTodaysAppointments( int branchId ) {
		LocalDate localDate = LocalDate.now();
		Date today = Date.from( localDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );

		List<Appointment> list = appointmentRepository.findTodayAppointments( today );
		List<AppointmentResponseDto> dtos = appointmentMapper.toList( list );
		for ( AppointmentResponseDto dto : dtos ) {
			Optional<Doctor> doctorOpt = doctorRepository.findById( dto.getDoctorId() );
			if ( doctorOpt.isPresent() ) {
				dto.setDoctorName( doctorOpt.get().getFirstName() + " " + doctorOpt.get().getLastName() );
			}

			Optional<Patient> patientOpt = patientRepository.findById( dto.getPatientId() );
			if ( patientOpt.isPresent() ) {
				dto.setPatientName( patientOpt.get().getFirstName() + " " + patientOpt.get().getLastName() );
			}
		}
		return dtos;
	}

	@Override
	public AppointmentResponseDto getAppointmentById( Long id ) {
		Optional<Appointment> opt = appointmentRepository.findById( id );
		if ( opt.isPresent() )
			return appointmentMapper.toDto( opt.get() );
		return null;
	}

	@Override
	public boolean updateAppointment( @Valid AppointmentRequestDto dto ) {
		try {
			Appointment entity = appointmentMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranch() );
			if ( opt.isPresent() ) {
				entity.setBranch( opt.get() );
			}
			Optional<Doctor> doctorOpt = doctorRepository.findById( dto.getDoctorId() );
			if ( doctorOpt.isPresent() ) {
				entity.setDoctor( doctorOpt.get() );
			}

			Optional<Patient> patientOpt = patientRepository.findById( dto.getPatientId() );
			if ( patientOpt.isPresent() ) {
				entity.setPatient( patientOpt.get() );
			}
			appointmentRepository.save( entity );
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AppointmentResponseDto> getTodaysAppointmentsForADoctor( Long doctorId, int branchId ) {
		LocalDate localDate = LocalDate.now();
		Date today = Date.from( localDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );

		List<Appointment> list = appointmentRepository.findTodayAppointmentsForDoctor( today, doctorId );
		List<AppointmentResponseDto> dtos = appointmentMapper.toList( list );
		for ( AppointmentResponseDto dto : dtos ) {
			Optional<Doctor> doctorOpt = doctorRepository.findById( dto.getDoctorId() );
			if ( doctorOpt.isPresent() ) {
				dto.setDoctorName( doctorOpt.get().getFirstName() + " " + doctorOpt.get().getLastName() );
			}

			Optional<Patient> patientOpt = patientRepository.findById( dto.getPatientId() );
			if ( patientOpt.isPresent() ) {
				dto.setPatientName( patientOpt.get().getFirstName() + " " + patientOpt.get().getLastName() );
			}
		}
		return dtos;
	}

}
