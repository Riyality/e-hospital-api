package com.riyality.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.doctor.DoctorRequestDto;
import com.riyality.dto.doctor.DoctorResponseDto;
import com.riyality.dto.staff.StaffRequestDto;
import com.riyality.dto.staff.StaffResponseDto;
import com.riyality.constants.MessageConstants;
import com.riyality.service.HrService;

@RestController
@RequestMapping( "/hrs" )
@CrossOrigin( "*" )
public class HrController {

	@Autowired
	private HrService hrService;

	@PostMapping( "/doctors" )
	public ResponseEntity<String> addDoctor( @Valid @RequestBody DoctorRequestDto doctorDto ) {
		boolean isAdded = hrService.addDoctor( doctorDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_DOCTOR_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_DOCTOR_ERROR_MESSAGE );

	}

	@GetMapping( "/doctors/{branchId}" )
	public ResponseEntity<Page<DoctorResponseDto>> allDoctors( @PathVariable int branchId, @RequestParam int pageNo, Pageable pageable ) {
		pageable = PageRequest.of( pageNo, 50 );
		return ResponseEntity.status( HttpStatus.OK ).body( hrService.allDoctors( branchId, pageable ) );

	}

	@GetMapping( "/all-doctors/{branchId}" )
	public ResponseEntity<List<DoctorResponseDto>> allDoctorsList( @PathVariable int branchId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( hrService.allDoctorsList( branchId ) );

	}

	@GetMapping( "/doctors/id/{id}" )
	public ResponseEntity<DoctorResponseDto> doctorByID( @PathVariable int id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( hrService.getDoctorById( id ) );
	}

	@PutMapping( "/doctors" )
	public ResponseEntity<String> updateDoctor( @Valid @RequestBody DoctorRequestDto doctorDto ) {
		boolean isAdded = hrService.updateDoctor( doctorDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_DOCTOR_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_DOCTOR_ERROR_MESSAGE );

	}

	@PostMapping( "/staffs" )
	public ResponseEntity<String> addStaff( @Valid @RequestBody StaffRequestDto staffDto ) {
		boolean isAdded = hrService.addStaff( staffDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_STAFF_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_STAFF_ERROR_MESSAGE );

	}

	@GetMapping( "/staffs/{branchId}" )
	public ResponseEntity<List<StaffResponseDto>> allStaff( @PathVariable int branchId ) {
		return ResponseEntity.status( HttpStatus.OK ).body( hrService.allStaff( branchId ) );

	}

	@PutMapping( "/staffs" )
	public ResponseEntity<String> updateStaff( @Valid @RequestBody StaffRequestDto dto ) {
		boolean isAdded = hrService.updateStaff( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_STAFF_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_STAFF_ERROR_MESSAGE );

	}

	@GetMapping( "/staffs/id/{id}" )
	public ResponseEntity<StaffResponseDto> staffByID( @PathVariable Long id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( hrService.staffByID( id ) );
	}
}
