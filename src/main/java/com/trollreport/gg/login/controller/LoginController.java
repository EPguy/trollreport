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
import com.trollreport.gg.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //�α��� ù ȭ�� ��û �޼ҵ�
    @RequestMapping(value = "/users/naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        System.out.println("���̹�:" + naverAuthUrl);
        model.addAttribute("url", naverAuthUrl);
        return "users/naverlogin";
    }

    //���̹� �α��� ������ callbackȣ�� �޼ҵ�
    @RequestMapping(value = "/users/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException, ParseException {
    	
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        
        //�α��� ����� ������ �о�´�.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        
        ObjectMapper objectMapper = new ObjectMapper();

        //��ȯ�� JSON ResultDto ��ü�� ��ȯ
        ResultDto jsonToResult = objectMapper.readValue(apiResult, ResultDto.class);
        UserDto user = jsonToResult.getResponse();
                
        if(loginService.getUser(user.getId()) == null) {
        	loginService.insertUser(user);
        } 
        
        session.setAttribute("userInfo", user);
        return "redirect:/";
    }
    
  //���̹� �α��� ������ callbackȣ�� �޼ҵ�
    @RequestMapping("/users/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        return "redirect:/";
    }
}