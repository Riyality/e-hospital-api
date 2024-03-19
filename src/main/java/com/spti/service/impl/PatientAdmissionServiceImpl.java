package com.spti.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.BillRepository;
import com.spti.dao.BranchDao;
import com.spti.dao.CotRepository;
import com.spti.dao.DoctorRepository;
import com.spti.dao.PatientAdmissionRepository;
import com.spti.dao.PatientRepository;
import com.spti.dao.WardRepository;
import com.spti.dto.patient.BillRequestDto;
import com.spti.dto.patient.DischargeResponseDto;
import com.spti.dto.patient.PatientAdmissionRequestDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.entity.Bill;
import com.spti.entity.Branch;
import com.spti.entity.Cot;
import com.spti.entity.Doctor;
import com.spti.entity.Patient;
import com.spti.entity.PatientAdmission;
import com.spti.entity.Ward;
import com.spti.mapper.DoctorMapper;
import com.spti.mapper.cot.CotMapper;
import com.spti.mapper.patient.BillMapper;
import com.spti.mapper.patient.PatientAdmissionMapper;
import com.spti.mapper.patient.PatientMapper;
import com.spti.mapper.ward.WardMapper;
import com.spti.service.PatientAdmissionService;

@Service
public class PatientAdmissionServiceImpl implements PatientAdmissionService {

	@Autowired
	private PatientAdmissionRepository admissionRepository;

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private PatientAdmissionMapper admissionMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private CotRepository cotRepository;

	@Autowired
	private WardRepository wardRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private WardMapper wardMapper;

	@Autowired
	private CotMapper cotMapper;

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private DoctorMapper doctorMapper;

	@Autowired
	private BillMapper billMapper;

	@Autowired
	private BillRepository billRepository;

	@Override
	public boolean addAdmission( PatientAdmissionRequestDto dto ) {

		try {
			PatientAdmission entity = admissionMapper.toEntity( dto );
			Optional<Branch> opt = branchDao.findById( dto.getBranchId() );
			if ( opt.isPresent() )
				entity.setBranch( opt.get() );

			Optional<Patient> patient = patientRepository.findById( dto.getPatientId() );
			if ( patient.isPresent() )
				entity.setPatient( patient.get() );

			Optional<Ward> ward = wardRepository.findById( dto.getWardId() );
			if ( ward.isPresent() )
				entity.setWard( ward.get() );

			Optional<Cot> cot = cotRepository.findById( dto.getCotId() );
			if ( cot.isPresent() )
				entity.setCot( cot.get() );

			Optional<Doctor> doctor = doctorRepository.findById( dto.getDoctorId() );
			if ( doctor.isPresent() )
				entity.setDoctor( doctor.get() );
			entity.setAdmissionStatus( "Admitted" );

			admissionRepository.save( entity );

			if ( cot.isPresent() ) {
				Cot cotToupdate = cot.get();
				cotToupdate.setStatus( "Occupied" );
				cotRepository.save( cotToupdate );
			}

			if ( patient.isPresent() ) {
				patient.get().setAdmissionStatus( "Admitted" );
				patientRepository.save( patient.get() );
			}

			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public DischargeResponseDto dischargePatient( Long id ) {
		Optional<Patient> patientOpt = patientRepository.findById( id );
		if ( patientOpt.isPresent() ) {
			PatientAdmission patientAdmission = admissionRepository.findByPatientAndAdmissionStatus( patientOpt.get(), "Admitted" );
			DischargeResponseDto dto = new DischargeResponseDto();
			dto.setAdmissionId( patientAdmission.getAdmissionId() );
			dto.setAdmissionDate( patientAdmission.getAdmissionDate() );
			dto.setDischargeDate( LocalDateTime.now() );
			dto.setWard( wardMapper.toDto( patientAdmission.getWard() ) );
			dto.setCot( cotMapper.toDto( patientAdmission.getCot() ) );
			dto.setPatient( patientMapper.toDto( patientAdmission.getPatient() ) );
			dto.setDoctor( doctorMapper.toDto( patientAdmission.getDoctor() ) );
			long daysDifference = ChronoUnit.DAYS.between( dto.getAdmissionDate(), dto.getDischargeDate() );
			float bill = patientAdmission.getWard().getCharges() * ( daysDifference + 1 );
			dto.setBill( bill );
			dto.setAdmittedDays( daysDifference + 1 );
			return dto;
		}

		return null;
	}

	@Override
	public List<PatientResponseDto> findAllAdmittedPatients( int branchId ) {
		List<PatientAdmission> admissions = admissionRepository.findAllByAdmissionStatus( "Admitted" );
		List<Patient> patients = admissions.stream().map( admission -> admission.getPatient() ).collect( Collectors.toList() );
		return patientMapper.toList( patients );
	}

	@Override
	public String generateAndPayBill( BillRequestDto dto ) {
		Optional<PatientAdmission> admission = admissionRepository.findById( dto.getAdmissionId() );
		if ( admission.isPresent() ) {
			Bill bill = billMapper.toEntity( dto );
			bill.setPatientAdmission( admission.get() );
			billRepository.save( bill );
			return "success";
		}
		return "fail";
	}

}
