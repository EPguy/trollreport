package com.trollreport.gg.login.domain;

public class UserDto {
	private int id;
	private String name;
	private String nickname;
	private String email;
	
	public UserDto(int id, String name, String nickname, String email) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
	}
	
	public UserDto() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
