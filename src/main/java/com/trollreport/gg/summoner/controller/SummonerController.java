package com.trollreport.gg.summoner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.summoner.service.SummonerService;

@Controller
@RequestMapping(value = "/user")
public class SummonerController {

    @Autowired
    private SummonerService summonerService;


    @RequestMapping("/info")
    public String user(@RequestParam("username") String username, Model model){
        try {
            //��ȯ�� ���� DB����
            if(ObjectUtils.isEmpty(summonerService.selectSummonerByName(username))) {
                summonerService.searchSummonerByName(username);
            }
            //DB���� ��ȯ�� ���� ��������
            SummonerDto summoner = summonerService.selectSummonerByName(username);
            
            //view���� ������ ����
            model.addAttribute("icon", "https://opgg-static.akamaized.net/images/profile_icons/profileIcon"+summoner.getProfileIconId()+".jpg");
            model.addAttribute("name", summoner.getName());
            //model.addAttribute("tier", leagueEntry.getTier());
            return "user";
        } catch (HttpStatusCodeException e) {
            int statusCode = e.getStatusCode().value();
            model.addAttribute("error", statusCode);
            return "error";
        }
    }
}