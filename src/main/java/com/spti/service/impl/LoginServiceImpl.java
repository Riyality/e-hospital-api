package com.spti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.DoctorRepository;
import com.spti.dao.LoginDao;
import com.spti.dao.StaffRepository;
import com.spti.dto.LoginRequestDto;
import com.spti.dto.LoginResponceDto;
import com.spti.entity.Doctor;
import com.spti.entity.Login;
import com.spti.entity.Staff;
import com.spti.mapper.LoginMapper;
import com.spti.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginmapper;

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public void add( LoginRequestDto loginDto ) {
		Login log = loginmapper.toLogin_entity( loginDto );
		loginDao.save( log );
	}

	@Override
	public LoginResponceDto login( LoginRequestDto dto ) {
		Login login = loginDao.findByUsername( dto.getUsername() );
		if ( login != null ) {
			if ( login.getRole().equals( "Doctor" ) ) {
				Doctor doctor = doctorRepository.findByEmail( login.getUsername() );
				LoginResponceDto temp = loginmapper.toEntity( login );
				temp.setLoginId( doctor.getId() );
				temp.setStatus( doctor.getStatus() );
				temp.setName( doctor.getFirstName() + " " + doctor.getLastName() );
				temp.setBranchId( doctor.getBranch().getId() );
				temp.setBranchName( doctor.getBranch().getName() );
				temp.setRole( "Doctor" );
				return temp;
			} else if ( login.getRole().equals( "HR" ) || login.getRole().equals( "Receptionist" ) ) {
				Staff staff = staffRepository.findByEmail( login.getUsername() );
				LoginResponceDto temp = loginmapper.toEntity( login );
				temp.setLoginId( staff.getId() );
				temp.setStatus( staff.getStatus() );
				temp.setName( staff.getFirstName() + " " + staff.getLastName() );
				temp.setBranchId( staff.getBranch().getId() );
				temp.setBranchName( staff.getBranch().getName() );
				temp.setRole( staff.getRole() );
				return temp;
			} else {
				LoginResponceDto temp = loginmapper.toEntity( login );
				temp.setStatus( "Active" );
				temp.setName( "Sonam Kothari" );
				temp.setBranchId( 1 );
				temp.setBranchName( "Bhadgao" );
				return temp;
			}
		}
		return null;
	}

}
