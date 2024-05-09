package com.riyality.mapper;

import org.springframework.stereotype.Component;

import com.riyality.dto.LoginRequestDto;
import com.riyality.dto.LoginResponceDto;
import com.riyality.entity.Login;

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
