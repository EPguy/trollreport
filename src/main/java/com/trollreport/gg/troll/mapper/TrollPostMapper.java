package com.trollreport.gg.troll.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.trollreport.gg.troll.domain.SearchDto;
import com.trollreport.gg.troll.domain.TrollCommentDto;
import com.trollreport.gg.troll.domain.TrollLikeDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollPostMapper {
	public int getTrollPostCount(String name);
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertPost(TrollPostDto trollPostDto);
	public List<TrollPostDto> getPostList(SearchDto searchDto);
	public TrollPostDto getPost(int id);
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void createLike(HashMap<String, Object> map);
	public TrollLikeDto isLike(HashMap<String, Object> map);
	public void increaseLike(HashMap<String, Object> map);
	public void decreaseLike(HashMap<String, Object> map);
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertComment(TrollCommentDto trollComment);
}
