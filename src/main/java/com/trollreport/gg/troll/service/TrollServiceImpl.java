package com.trollreport.gg.troll.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trollreport.gg.troll.domain.SearchDto;
import com.trollreport.gg.troll.domain.TrollCommentDto;
import com.trollreport.gg.troll.domain.TrollLikeDto;
import com.trollreport.gg.troll.domain.TrollPostDto;
import com.trollreport.gg.troll.mapper.TrollPostMapper;

@Service
public class TrollServiceImpl implements TrollService {
    @Autowired
    TrollPostMapper trollPostMapper;

    @Override
    public int getTrollPostCount(String name) {
    	return trollPostMapper.getTrollPostCount(name);
    }
    
    @Override
    public void insertPost(TrollPostDto trollPostDto) {
    	trollPostMapper.insertPost(trollPostDto);
    }
    
    @Override
    public List<TrollPostDto> getPostList(SearchDto searchDto) {
    	//공백 제거
    	searchDto.setSearchUser(searchDto.getSearchUser().replaceAll(" ", ""));
    	searchDto.setSearchUser(searchDto.getSearchUser().replaceAll("\\p{Z}", ""));
    	searchDto.setSearchUser(searchDto.getSearchUser().toLowerCase());
    	return trollPostMapper.getPostList(searchDto);
    }
    
    @Override
    public TrollPostDto getPost(int id) {
    	return trollPostMapper.getPost(id);
    }
    
    @Override
    public void createLike(HashMap<String, Object> map) {
    	trollPostMapper.createLike(map);
    }
    
    @Override
    public TrollLikeDto isLike(HashMap<String, Object> map) {
    	return trollPostMapper.isLike(map);
    }
    
    @Override
    public void increaseLike(HashMap<String, Object> map) {
    	trollPostMapper.increaseLike(map);
    }
    
    @Override
    public void decreaseLike(HashMap<String, Object> map) {
    	trollPostMapper.decreaseLike(map);
    }
    
    @Override
    public void insertComment(TrollCommentDto trollComment) {
    	trollPostMapper.insertComment(trollComment);
    }
}
