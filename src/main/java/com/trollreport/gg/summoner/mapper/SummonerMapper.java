package com.trollreport.gg.summoner.mapper;

import com.trollreport.gg.summoner.domain.SummonerDto;

public interface SummonerMapper {
	public boolean isSummonerExists(String name);
    public void insertSummoner(String name);
	public SummonerDto selectSummoner(String name);
    public int insertSummoner(SummonerDto summonerDto);
}
