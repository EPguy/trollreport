package com.trollreport.gg.troll.service;

import java.util.List;

import com.trollreport.gg.troll.domain.SearchDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollService {
	public int getTrollPostCount(String name);
	public void insertPost(TrollPostDto trollPostDto);
	public List<TrollPostDto> getPostList(SearchDto searchDto);
	public TrollPostDto getPost(int id);
}
