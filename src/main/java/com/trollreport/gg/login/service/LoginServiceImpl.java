package com.trollreport.gg.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trollreport.gg.login.domain.UserDto;
import com.trollreport.gg.login.mapper.LoginMapper;

@Service("com.trollreport.gg.login.service.LoginServiceImpl")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public void insertUser(UserDto userDto) {
		loginMapper.insertUser(userDto);
	}
	
	@Override
	public UserDto getUser(int id) {
		return loginMapper.getUser(id);
	}
}
