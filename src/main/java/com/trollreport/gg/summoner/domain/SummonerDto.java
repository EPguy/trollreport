package com.trollreport.gg.summoner.domain;

public class SummonerDto {
    private String id;
    private String accountId;
    private String name;
    private long summonerLevel;
    private int profileIconId;
    private int trollCount;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	public int getTrollCount() {
		return trollCount;
	}
	public void setTrollCount(int trollCount) {
		this.trollCount = trollCount;
	}
	
}
