package com.trollreport.gg.troll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TrollPostDto> getPostList(String name) {
    	//���� ����
    	name = name.replaceAll(" ", "");
    	name = name.replaceAll("\\p{Z}", "");
    	
    	return trollPostMapper.getPostList(name);
    }
}
