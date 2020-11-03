package com.trollreport.gg.troll.service;

import java.util.HashMap;
import java.util.List;

import com.trollreport.gg.troll.domain.SearchDto;
import com.trollreport.gg.troll.domain.TrollCommentDto;
import com.trollreport.gg.troll.domain.TrollLikeDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface TrollService {
	public int getTrollPostCount(String name);
	public void insertPost(TrollPostDto trollPostDto);
	public List<TrollPostDto> getPostList(SearchDto searchDto);
	public TrollPostDto getPost(int id);
	public void createLike(HashMap<String, Object> map);
	public TrollLikeDto isLike(HashMap<String, Object> map);
	public void increaseLike(HashMap<String, Object> map);
	public void decreaseLike(HashMap<String, Object> map);
	public void insertComment(TrollCommentDto trollComment);
	public List<TrollCommentDto> getCommentList(int id);
	public List<TrollPostDto> getTrollBoardTop5();
	public void deleteTrollPost(int id);
}
