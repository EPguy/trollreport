package com.trollreport.gg.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.trollreport.gg.login.domain.NaverLoginBO;
import com.trollreport.gg.login.domain.ResultDto;
import com.trollreport.gg.login.domain.UserDto;

@Controller
public class LoginController {

    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/users/naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        System.out.println("네이버:" + naverAuthUrl);
        model.addAttribute("url", naverAuthUrl);
        return "users/naverlogin";
    }

    //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value = "/users/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException, ParseException {
    	
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        
        //로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        
        ObjectMapper objectMapper = new ObjectMapper();

        //변환한 JSON ResultDto 객체로 변환
        ResultDto jsonToResult = objectMapper.readValue(apiResult, ResultDto.class);
        
        session.setAttribute("userInfo", jsonToResult.getResponse());
        return "redirect:/";
    }
    
  //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping("/users/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        return "redirect:/";
    }
}