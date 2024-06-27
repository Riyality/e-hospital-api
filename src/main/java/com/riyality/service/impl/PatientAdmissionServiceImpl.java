package com.riyality.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.riyality.dao.BillRepository;
import com.riyality.dao.BranchDao;
import com.riyality.dao.CotRepository;
import com.riyality.dao.DoctorRepository;
import com.riyality.dao.PatientAdmissionRepository;
import com.riyality.dao.PatientRepository;
import com.riyality.dao.WardRepository;
import com.riyality.dto.patient.BillRequestDto;
import com.riyality.dto.patient.DischargeResponseDto;
import com.riyality.dto.patient.PatientAdmissionRequestDto;
import com.riyality.dto.patient.PatientResponseDto;
import com.riyality.entity.Bill;
import com.riyality.entity.Branch;
import com.riyality.entity.Cot;
import com.riyality.entity.Doctor;
import com.riyality.entity.Patient;
import com.riyality.entity.PatientAdmission;
import com.riyality.entity.Ward;
import com.riyality.mapper.DoctorMapper;
import com.riyality.mapper.cot.CotMapper;
import com.riyality.mapper.patient.BillMapper;
import com.riyality.mapper.patient.PatientAdmissionMapper;
import com.riyality.mapper.patient.PatientMapper;
import com.riyality.mapper.ward.WardMapper;
import com.riyality.service.PatientAdmissionService;

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
			dto.setDischargeDate( LocalDate.now() );
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

	@Override
	public DischargeResponseDto updateStatusPatient(Long id) {
	    Optional<PatientAdmission> patientAdmissionOpt = admissionRepository.findById(id);

	    if (patientAdmissionOpt.isPresent()) {
	        PatientAdmission patientAdmission = patientAdmissionOpt.get();
	        patientAdmission.setAdmissionStatus("Discharged");

	      
	        LocalDate today = LocalDate.now();
	        patientAdmission.setDischargeDate(today);

	        admissionRepository.save(patientAdmission);

	        Patient patient = patientAdmission.getPatient();
	        patient.setAdmissionStatus("Discharged");

	   

	        patientRepository.save(patient);

	       
	        DischargeResponseDto response = new DischargeResponseDto();
	        response.setDischargeDate(today);
	        return response;
	    } else {
	        throw new ResourceNotFoundException("PatientAdmission not found with id: " + id);
	    }
	}




}
