package com.trollreport.gg.util;

public class ImageSuccess {
	private int uploaded;
	private String url;

	public ImageSuccess(String url, int uploaded) {
		super();
		this.uploaded = uploaded;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUploaded() {
		return uploaded;
	}

	public void setUploaded(int uploaded) {
		this.uploaded = uploaded;
	}
	
}
