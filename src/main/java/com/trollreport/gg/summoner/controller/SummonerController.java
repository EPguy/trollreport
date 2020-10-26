package com.trollreport.gg.summoner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.summoner.service.SummonerService;
import com.trollreport.gg.troll.domain.SearchDto;
import com.trollreport.gg.troll.domain.TrollPostDto;
import com.trollreport.gg.troll.service.TrollService;
import com.trollreport.gg.util.Messages;

@Controller
@RequestMapping("/summoner")
public class SummonerController {

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private TrollService trollService;
    
    @RequestMapping("/info.do")
    public ModelAndView user(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	String username = request.getParameter("username");
    	
    	if(username == "") {
    		Messages.getScriptAlertGoBack(response, "��ȯ����� �Է����ּ���.");
    		return null;
    	}
    	
    	if(!summonerService.isSummonerExists(username)) {
    		Messages.getScriptAlertGoBack(response, "�������� �ʴ� ��ȯ���Դϴ�.");
    		return null;
    	}
    	/* ���� ó�� */
    	
    	/* ���� */
    	//db�� ������� �ʴ� ��ȯ���Ͻ� db�� ����
        if(summonerService.selectSummonerByName(username) == null) {
        	summonerService.insertSummoner(username);
        }
        
        SummonerDto summoner = summonerService.selectSummonerByName(username);
        
        SearchDto searchDto = new SearchDto();
        searchDto.setSearchUser(summoner.getName());
        List<TrollPostDto> trollPostList = trollService.getPostList(searchDto);
        
        //view���� ������ ����
        mav.addObject("icon", "http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/" +summoner.getProfileIconId() + ".png");
        mav.addObject("name", summoner.getName());
        mav.addObject("searchDto", searchDto);
        mav.addObject("trollPostList", trollPostList);
        mav.addObject("troll_post_count", trollService.getTrollPostCount(summoner.getName()));
        mav.setViewName("/summoner/userinfo");
        return mav;
        /* ���� */
    }
}