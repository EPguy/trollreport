package com.trollreport.gg.login.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultDto {
	private UserDto response;
	private String resultCode;
	private String message;
	
	
	
	public ResultDto(String resultCode, String message, UserDto response) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		this.response = response;
	}
	
	public ResultDto() {
		
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserDto getResponse() {
		return response;
	}
	public void setResponse(UserDto response) {
		this.response = response;
	}
	
	
}
