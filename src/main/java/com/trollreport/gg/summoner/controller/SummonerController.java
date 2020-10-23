package com.trollreport.gg.summoner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;

import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.summoner.service.SummonerService;
import com.trollreport.gg.troll.service.TrollService;

@Controller
@RequestMapping("/summoner")
public class SummonerController {

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private TrollService trollService;
    
    @RequestMapping("/info")
    public ModelAndView user(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	String username = request.getParameter("username");
        try {
            //��ȯ�� ���� DB����
            if(ObjectUtils.isEmpty(summonerService.selectSummonerByName(username))) {
                summonerService.searchSummonerByName(username);
            }
            //DB���� ��ȯ�� ���� ��������
            SummonerDto summoner = summonerService.selectSummonerByName(username);
            
            //view���� ������ ����
            mav.addObject("icon", "https://opgg-static.akamaized.net/images/profile_icons/profileIcon"+summoner.getProfileIconId()+".jpg");
            mav.addObject("name", summoner.getName());
            mav.addObject("troll_post_count", trollService.getTrollPostCount());
            mav.setViewName("/summoner/userinfo");
            return mav;
        } catch (HttpStatusCodeException e) {
            int statusCode = e.getStatusCode().value();
            mav.addObject("error", statusCode);
            mav.setViewName("/error/error");
            return mav;
        }
    }
}