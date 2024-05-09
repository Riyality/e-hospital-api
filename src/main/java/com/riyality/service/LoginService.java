package com.riyality.service;

import com.riyality.dto.LoginRequestDto;
import com.riyality.dto.LoginResponceDto;

public interface LoginService {

	public void add( LoginRequestDto loginDto );

	public LoginResponceDto login( LoginRequestDto dto );

}
