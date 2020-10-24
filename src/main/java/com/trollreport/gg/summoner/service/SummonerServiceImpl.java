package com.trollreport.gg.summoner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
    
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    RestTemplate restTemplate = restTemplateBuilder.build();
    
    @Override
    public boolean isSummonerExists(String name) {
    	try {
    		SummonerDto summonerDto = restTemplate.getForObject("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key=" + api_key, SummonerDto.class);
    	} catch (final HttpClientErrorException e) {
    		return false;
    	}
    	return true;
    }
    
    @Override
    public void insertSummoner(String name) {
        SummonerDto summonerDto = restTemplate.getForObject("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key=" + api_key, SummonerDto.class);
        summonerMapper.insertSummoner(summonerDto);
        //LeagueEntryDto[] leagueEntryDto = restTemplate.getForObject("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerDto.getId() + "?api_key=" + api_key, LeagueEntryDto[].class);
        //if(leagueEntryDto.length > 0) {
        //    leagueEntryMapper.insertLeagueEntry(leagueEntryDto[0]);
        //}
    }
    
    @Override
    public SummonerDto selectSummonerByName(String name) {
    	//공백 제거
    	name = name.replaceAll(" ", "");
    	name = name.replaceAll("\\p{Z}", "");
        
        return summonerMapper.selectSummoner(name);
    }

    @Override
    public LeagueEntryDto selectLeagueEntryByName(String name) {
        return leagueEntryMapper.selectLeagueEntryByName(name);
    }
}