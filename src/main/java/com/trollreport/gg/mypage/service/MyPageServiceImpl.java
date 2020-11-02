package com.trollreport.gg.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trollreport.gg.login.domain.UserDto;
import com.trollreport.gg.mypage.mapper.MyPageMapper;
import com.trollreport.gg.troll.domain.TrollPostDto;

@Service("com.trollreport.gg.mypage.service.MyPageServiceImpl")
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageMapper myPageMapper;
	
	@Override
	public List<TrollPostDto> getNoConfirm(UserDto user) {
		return myPageMapper.getNoConfirm(user);
	}
	
	@Override
	public List<TrollPostDto> getYesConfirm(UserDto user) {
		return myPageMapper.getYesConfirm(user);
	}
}
