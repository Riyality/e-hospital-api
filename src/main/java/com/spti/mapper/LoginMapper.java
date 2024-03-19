package com.spti.mapper;

import org.springframework.stereotype.Component;

import com.spti.dto.LoginRequestDto;
import com.spti.dto.LoginResponceDto;
import com.spti.entity.Login;

@Component
public class LoginMapper {

	public Login toLogin_entity( LoginRequestDto loginDto ) {
		Login login = new Login();
		login.setUsername( loginDto.getUsername() );
		login.setPassword( loginDto.getPassword() );
		login.setRole( loginDto.getRole() );
		return login;
	}

	public LoginResponceDto toEntity( Login login2 ) {
		LoginResponceDto loginDto = new LoginResponceDto();
		loginDto.setId( login2.getId() );
		loginDto.setUsername( login2.getUsername() );
		loginDto.setRole( login2.getRole() );

		return loginDto;
	}
}
