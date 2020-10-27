package com.trollreport.gg.summoner.service;

import java.util.List;

import com.trollreport.gg.summoner.domain.LeagueEntryDto;
import com.trollreport.gg.summoner.domain.SummonerDto;
import com.trollreport.gg.troll.domain.TrollPostDto;

public interface SummonerService {
    public boolean isSummonerExists(String name);
    public void insertSummoner(String name);
    public void updateTrollCount(SummonerDto troller);
    public SummonerDto selectSummonerByName(String name);
    public LeagueEntryDto selectLeagueEntryByName(String name);
    public List<SummonerDto> getTrollListTop5();
}
