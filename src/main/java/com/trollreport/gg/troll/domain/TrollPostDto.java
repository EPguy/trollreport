package com.trollreport.gg.troll.domain;

import org.springframework.stereotype.Component;

@Component
public class TrollPostDto{
    /** ��ȣ (PK) */
    private int id;

    /** ī�װ� */
    private String category;

    /** ���� */
    private String title;

    /** ���� */
    private String content;

    /** �ۼ��� */
    private String writer;

    /** Ʈ�ѷ� */
    private String troller;

	/** Ʈ�ѷ� accountId */
    private String trollerId;

    /** ��ȸ �� */
    private int viewCnt;

    /** ���� ���� */
    private String deleteYn;

    /** ����� */
    private String insertTime;

    /** ������ */
    private String updateTime;

    /** ������ */
    private String deleteTime;
    
    private int likeCount;
    
    private int unlikeCount;
    
    private int totalLikeCount;
    
    private int trollConfirm;
    
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

	public int getUnlikeCount() {
		return unlikeCount;
	}

	public void setUnlikeCount(int unlikeCount) {
		this.unlikeCount = unlikeCount;
	}

	public int getTotalLikeCount() {
		return totalLikeCount;
	}

	public void setTotalLikeCount(int totalLikeCount) {
		this.totalLikeCount = totalLikeCount;
	}

	public int getTrollConfirm() {
		return trollConfirm;
	}

	public void setTrollConfirm(int trollConfirm) {
		this.trollConfirm = trollConfirm;
	}
}
