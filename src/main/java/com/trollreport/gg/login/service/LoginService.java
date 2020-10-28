package com.trollreport.gg.login.service;

import com.trollreport.gg.login.domain.UserDto;

public interface LoginService {
	public void insertUser(UserDto userDto);
	public UserDto getUser(int id);
}
