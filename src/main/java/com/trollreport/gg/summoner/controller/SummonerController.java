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
    	
    	/* 예외 처리 */
    	if(username == "") {
    		Messages.getScriptAlertGoBack(response, "소환사명을 입력해주세요.");
    		return null;
    	}
    	
    	if(!summonerService.isSummonerExists(username)) {
    		Messages.getScriptAlertGoBack(response, "존재하지 않는 소환사입니다.");
    		return null;
    	}
    	/* 예외 처리 */
    	
    	/* 실행 */
    	//db에 저장되지 않는 소환사일시 db에 저장
        if(summonerService.selectSummonerByName(username) == null) {
        	summonerService.insertSummoner(username);
        }
        
        SummonerDto summoner = summonerService.selectSummonerByName(username);
        List<TrollPostDto> trollPostList = trollService.getPostList(username);
        
        //view에게 데이터 전달
        mav.addObject("icon", "http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/" +summoner.getProfileIconId() + ".png");
        mav.addObject("name", summoner.getName());
        mav.addObject("trollPostList", trollPostList);
        mav.addObject("troll_post_count", trollService.getTrollPostCount(summoner.getName()));
        mav.setViewName("/summoner/userinfo");
        return mav;
        /* 실행 */
    }
}