package com.trollreport.gg.troll.domain;

import org.springframework.stereotype.Component;

@Component
public class SearchDto {
    
	private String searchUser;
	private int page = 0;
	private int line_per_page = 10;
	private int total_rows;
	private long total_pages;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = (page - 1) * 10;
	}

	public int getLine_per_page() {
		return line_per_page;
	}

	public void setLine_per_page(int line_per_page) {
		this.line_per_page = line_per_page;
	}

	public int getTotal_rows() {
		return total_rows;
	}

	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}

	public long getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int dataLength) {
		int totalPages = dataLength % line_per_page == 0 ? dataLength / line_per_page : (dataLength / line_per_page) + 1;
		if(totalPages == 0) {
			totalPages = 1;
		}
		
		this.total_pages = totalPages;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}  
}