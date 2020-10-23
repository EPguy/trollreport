package com.trollreport.gg.troll.service;

import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollService {
	public int getTrollPostCount();
	public void insertPost(TrollPostDto trollPostDto);
}
