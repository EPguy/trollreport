package com.trollreport.gg.troll.controller;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trollreport.gg.login.domain.UserDto;
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
    	HttpSession session = request.getSession();
    	UserDto user = (UserDto) session.getAttribute("userInfo");
    	
    	if(user == null) {
    		Messages.getScriptAlertGoBack(response, "�α����� �ʿ��� �����Դϴ�.");
    		return null;
    	}
    	
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
    	
    	if(trollPost.getCategory().equals("������")) {
    		System.out.println("hi");
    		Messages.getScriptAlertGoBack(response, "�������� �� �� �����ϴ�.");
    		return null;
    	}
    	
    	
        mav.addObject("icon", "http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/" + troller.getProfileIconId() + ".png");
        mav.addObject("id", id);
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
        	Messages.getScriptAlertGoBack(response, "������ �Է��� �ּ���.");
        	return null;
        }
        
        if(!summonerService.isSummonerExists(troller)) {
        	Messages.getScriptAlertGoBack(response, "�������� �ʴ� ��ȯ���Դϴ�.");
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
    
    @RequestMapping("/like.do")
    public ModelAndView likeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        String id = request.getParameter("id");
        
        TrollPostDto trollPost = trollService.getPost(Integer.parseInt(id));
    	UserDto user = (UserDto) request.getSession().getAttribute("userInfo");
    	
    	if(user == null) {
    		Messages.getScriptAlertGoBack(response, "�α����� �ʿ��� �����Դϴ�.");
    		return null;
    	}
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("bid", trollPost.getId());
    	map.put("uid", user.getId());
    	
    	if(trollService.isLike(map) != null)  {
    		Messages.getScriptAlertGoBack(response, "�̹� ��õ�� �Խñ��Դϴ�.");
    		return null;
    	}
    	
    	trollService.createLike(map);
    	
    	mav.setViewName("redirect:/troll/board.do?id="+id);
    	return mav;
    }
}