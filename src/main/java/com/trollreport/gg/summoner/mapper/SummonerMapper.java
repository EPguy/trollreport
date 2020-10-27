package com.trollreport.gg.summoner.mapper;

import java.util.List;

import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface SummonerMapper {
	public boolean isSummonerExists(String name);
    public void insertSummoner(String name);
    public void updateTrollCount(SummonerDto troller);
	public SummonerDto selectSummoner(String name);
    public int insertSummoner(SummonerDto summonerDto);
    public List<SummonerDto> getTrollListTop5();
}
