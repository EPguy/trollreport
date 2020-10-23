package com.trollreport.gg.troll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trollreport.gg.troll.domain.TrollPostDto;
import com.trollreport.gg.troll.mapper.TrollPostMapper;

@Service
public class TrollServiceImpl implements TrollService {
    @Autowired
    TrollPostMapper trollPostMapper;

    @Override
    public int getTrollPostCount() {
    	return trollPostMapper.getTrollPostCount();
    }
    
    @Override
    public void insertPost(TrollPostDto trollPostDto) {
    	trollPostMapper.insertPost(trollPostDto);
    }
}
