package com.trollreport.gg.troll.controller;

import java.net.URLEncoder;

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
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String troller = request.getParameter("troller");
        
        TrollPostDto trollPost = new TrollPostDto();
        trollPost.setCategory(category);
        trollPost.setTitle(title);
        trollPost.setContent(content);
        trollPost.setWriter(writer);
        trollPost.setTroller(troller);
    	trollService.insertPost(trollPost);
    	
    	String trollerParam = URLEncoder.encode(troller, "UTF-8");
    	mav.setViewName("redirect:/summoner/info.do?username=" + trollerParam);
    	return mav;
    }
}