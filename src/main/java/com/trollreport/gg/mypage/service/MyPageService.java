package com.trollreport.gg.mypage.service;

import java.util.List;

import com.trollreport.gg.login.domain.UserDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface MyPageService {
	public List<TrollPostDto> getNoConfirm(UserDto user);
	public List<TrollPostDto> getYesConfirm(UserDto user);
}
