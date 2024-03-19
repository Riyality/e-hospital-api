package com.spti.service;

import com.spti.dto.LoginRequestDto;
import com.spti.dto.LoginResponceDto;

public interface LoginService {

	public void add( LoginRequestDto loginDto );

	public LoginResponceDto login( LoginRequestDto dto );

}
