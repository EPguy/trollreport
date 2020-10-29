package com.trollreport.gg.troll.domain;

import org.springframework.stereotype.Component;

@Component
public class TrollPostDto{
    /** 번호 (PK) */
    private int id;

    /** 카테고리 */
    private String category;

    /** 제목 */
    private String title;

    /** 내용 */
    private String content;

    /** 작성자 */
    private String writer;

    /** 트롤러 */
    private String troller;

	/** 트롤러 accountId */
    private String trollerId;

    /** 조회 수 */
    private int viewCnt;

    /** 삭제 여부 */
    private String deleteYn;

    /** 등록일 */
    private String insertTime;

    /** 수정일 */
    private String updateTime;

    /** 삭제일 */
    private String deleteTime;
    
    /** 삭제일 */
    private int likeCount;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTroller() {
		return troller;
	}

	public void setTroller(String troller) {
		this.troller = troller;
	}

	public String getTrollerId() {
		return trollerId;
	}

	public void setTrollerId(String trollerId) {
		this.trollerId = trollerId;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
}
