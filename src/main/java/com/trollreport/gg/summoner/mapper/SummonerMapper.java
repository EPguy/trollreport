package com.trollreport.gg.summoner.mapper;

import com.trollreport.gg.summoner.domain.SummonerDto;

public interface SummonerMapper {
	public SummonerDto selectSummoner(String name);
    public int insertSummoner(SummonerDto summonerDto);
}
