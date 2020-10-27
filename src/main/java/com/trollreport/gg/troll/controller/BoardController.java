package com.trollreport.gg.troll.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.summoner.service.SummonerService;
import com.trollreport.gg.troll.domain.TrollPostDto;
import com.trollreport.gg.troll.service.TrollService;
import com.trollreport.gg.util.Messages;

@Controller
@RequestMapping(value = "/troll")
public class BoardController {

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private TrollService trollService;

    @RequestMapping("/report.do")
    public ModelAndView report(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("troll/report");
    	return mav;
    }
    
    @RequestMapping("/board.do")
    public ModelAndView board(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        String id = request.getParameter("id");
        
        TrollPostDto trollPost = trollService.getPost(Integer.parseInt(id));
    	SummonerDto troller = summonerService.selectSummonerByName(trollPost.getTroller());
    	
    	if(trollPost.getCategory().equals("한줄평")) {
    		System.out.println("hi");
    		Messages.getScriptAlertGoBack(response, "한줄평은 볼 수 없습니다.");
    		return null;
    	}
    	
    	
        mav.addObject("icon", "http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/" + troller.getProfileIconId() + ".png");
        mav.addObject("name", troller.getName());
        mav.addObject("title", trollPost.getTitle());
        mav.addObject("category", trollPost.getCategory());
        mav.addObject("writer", trollPost.getWriter());
        mav.addObject("content", trollPost.getContent());
    	mav.setViewName("troll/board");
    	return mav;
    }
    
    @RequestMapping("/insert.do")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String troller = request.getParameter("troller");
        
        System.out.println(category + title + content + writer + troller);
        
        if(content.replace(" ", "").equals("")) {
        	Messages.getScriptAlertGoBack(response, "내용을 입력해 주세요.");
        	return null;
        }
        
        if(!summonerService.isSummonerExists(troller)) {
        	Messages.getScriptAlertGoBack(response, "존재하지 않는 소환사입니다.");
        	return null;
        }
        
        if(ObjectUtils.isEmpty(summonerService.selectSummonerByName(troller))) {
        	summonerService.insertSummoner(troller);
        }
        
        SummonerDto trollerDto = summonerService.selectSummonerByName(troller);
        String trollerName = trollerDto.getName();
        
        TrollPostDto trollPost = new TrollPostDto();
        trollPost.setCategory(category);
        trollPost.setTitle(title);
        trollPost.setContent(content);
        trollPost.setWriter(writer);
        trollPost.setTroller(trollerName);
    	trollService.insertPost(trollPost);
    	
    	summonerService.updateTrollCount(trollerDto);
    	
    	String trollerParam = URLEncoder.encode(troller, "UTF-8");
    	mav.setViewName("redirect:/summoner/info.do?username=" + trollerParam + "&page=1");
    	return mav;
    }
}