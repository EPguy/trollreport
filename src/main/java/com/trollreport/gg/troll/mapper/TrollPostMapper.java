package com.trollreport.gg.troll.mapper;

import org.apache.ibatis.annotations.Options;

import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollPostMapper {
	public int getTrollPostCount();
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertPost(TrollPostDto trollPostDto);
}
