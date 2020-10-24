package com.trollreport.gg.troll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollPostMapper {
	public int getTrollPostCount(String name);
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertPost(TrollPostDto trollPostDto);
	public List<TrollPostDto> getPostList(String name);
}
