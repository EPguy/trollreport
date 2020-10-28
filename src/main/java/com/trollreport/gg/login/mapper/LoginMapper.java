package com.trollreport.gg.login.mapper;

import com.trollreport.gg.login.domain.UserDto;

public interface LoginMapper {
	public void insertUser(UserDto userDto);
	public UserDto getUser(int id);
}
