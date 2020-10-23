package com.trollreport.gg.summoner.mapper;

import com.trollreport.gg.summoner.domain.LeagueEntryDto;

public interface LeagueEntryMapper {
	public LeagueEntryDto selectLeagueEntryByName(String name);
    public int insertLeagueEntry(LeagueEntryDto leagueEntryDto);
}
