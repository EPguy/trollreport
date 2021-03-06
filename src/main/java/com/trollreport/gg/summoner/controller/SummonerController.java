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
    	if(request.getParameter("page") == null) {
    		Messages.getScriptAlertGoBack(response, "잘못된 접근입니다.");
    		return null;
    	}
    	
    	if(request.getParameter("username") == null) {
    		Messages.getScriptAlertGoBack(response, "잘못된 접근입니다.");
    		return null;
    	}
    	
    	
    	ModelAndView mav = new ModelAndView();
    	int page = Integer.parseInt(request.getParameter("page"));
    	String username = request.getParameter("username");
    	
    	if(page <= 0) {
    		Messages.getScriptAlertGoBack(response, "잘못된 페이지입니다.");
    		return null;
    	}

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
        
        SearchDto searchDto = new SearchDto();
        searchDto.setSearchUser(summoner.getName());
        searchDto.setPage(page);
        searchDto.setTotal_pages(trollService.getTrollPostCount(username));
        List<TrollPostDto> trollPostList = trollService.getPostList(searchDto);
        
        //view에게 데이터 전달
        mav.addObject("icon", "http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/" +summoner.getProfileIconId() + ".png");
        mav.addObject("name", summoner.getName());
        mav.addObject("currentPage", page);
        mav.addObject("searchDto", searchDto);
        mav.addObject("trollPostList", trollPostList);
        mav.addObject("count", trollService.getTrollPostCount(summoner.getName()));
        mav.setViewName("/summoner/userinfo");
        return mav;
        /* 실행 */
    }
}