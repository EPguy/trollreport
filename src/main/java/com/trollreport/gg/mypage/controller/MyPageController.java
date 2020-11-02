package com.trollreport.gg.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trollreport.gg.login.domain.UserDto;
import com.trollreport.gg.mypage.service.MyPageService;
import com.trollreport.gg.troll.domain.TrollPostDto;
import com.trollreport.gg.util.Messages;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private MyPageService myPageService;
	
	@RequestMapping("/user.do")
	public ModelAndView myPageUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("userInfo");
		
		if(user == null) {
    		Messages.getScriptAlertGoBack(response, "로그인이 필요한 서비스입니다.");
    		return null;
    	}
		
		List<TrollPostDto> yesConfirmList = myPageService.getYesConfirm(user);
		List<TrollPostDto> noConfirmList = myPageService.getNoConfirm(user);
		
		ModelAndView mav = new ModelAndView("mypage/user");
		mav.addObject("yesConfirmList", yesConfirmList);
		mav.addObject("noConfirmList", noConfirmList);
		return mav;
	}
}
