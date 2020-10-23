package com.trollreport.gg.summoner.service;

import com.trollreport.gg.summoner.domain.LeagueEntryDto;
import com.trollreport.gg.summoner.domain.SummonerDto;

public interface SummonerService {
    public boolean searchSummonerByName(String name);
    public SummonerDto selectSummonerByName(String name);
    public LeagueEntryDto selectLeagueEntryByName(String name);
}
