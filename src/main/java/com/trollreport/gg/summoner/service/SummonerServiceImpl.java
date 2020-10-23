package com.trollreport.gg.summoner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.trollreport.gg.summoner.domain.LeagueEntryDto;
import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.summoner.mapper.LeagueEntryMapper;
import com.trollreport.gg.summoner.mapper.SummonerMapper;


@Service("com.trollreport.gg.summoner.service.SummonerServiceImpl")
public class SummonerServiceImpl implements SummonerService {

    private final String api_key = "RGAPI-8cfbacca-e4e9-4f46-bf2c-03a61372ef1a";
    @Autowired
    private SummonerMapper summonerMapper;
    @Autowired
    private LeagueEntryMapper leagueEntryMapper;


    @Override
    public boolean searchSummonerByName(String name) {
        if (ObjectUtils.isEmpty(summonerMapper.selectSummoner(name))) {
            //DB에 소환사가 없을 때
        	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        	RestTemplate restTemplate = restTemplateBuilder.build();
            SummonerDto summonerDto = restTemplate.getForObject("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key=" + api_key, SummonerDto.class);
            System.out.println(summonerDto.getName());
            summonerMapper.insertSummoner(summonerDto);
            //LeagueEntryDto[] leagueEntryDto = restTemplate.getForObject("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerDto.getId() + "?api_key=" + api_key, LeagueEntryDto[].class);
            //if(leagueEntryDto.length > 0) {
            //    leagueEntryMapper.insertLeagueEntry(leagueEntryDto[0]);
            //}
            return true;
        } else {
            return true;
        }
    }

    @Override
    public SummonerDto selectSummonerByName(String name) {
        return summonerMapper.selectSummoner(name);
    }

    @Override
    public LeagueEntryDto selectLeagueEntryByName(String name) {
        return leagueEntryMapper.selectLeagueEntryByName(name);
    }
}