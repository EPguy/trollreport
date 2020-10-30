package com.trollreport.gg.main.controller;

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

@Controller
public class MainController {
	@Autowired
	private SummonerService summonerService;
	
	@Autowired
	private TrollService trollService;
	
	@RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView("/main/main");
        List<SummonerDto> trollListTop5 = summonerService.getTrollListTop5();
        List<TrollPostDto> trollBoardTop5 = trollService.getTrollBoardTop5();
        mav.addObject("trollListTop5", trollListTop5);
        mav.addObject("trollBoardTop5", trollBoardTop5);
        return mav;
    }
}
