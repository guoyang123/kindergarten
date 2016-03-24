package com.kinder.noticedetail.model;

import java.io.Serializable;
import java.util.List;

import cn.kinder.bean.Kinder_DataSource;

public class NoticeDetail_DataSource extends Kinder_DataSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8590077465557725589L;

	private NoticeModel NoticeModel;
    private List<cn.kinder.bean.BabyModel> BabyModel;
    private List<cn.kinder.bean.BabyModel> HomeBabyModel;
    private int babynum;
    private int parentnum;
    private int isreg;
    
    private String type;//0：非活动1：活动
	public NoticeModel getNoticeModel() {
		return NoticeModel;
	}

	public void setNoticeModel(NoticeModel noticeModel) {
		NoticeModel = noticeModel;
	}

	public List<cn.kinder.bean.BabyModel> getBabyModel() {
		return BabyModel;
	}

	public void setBabyModel(List<cn.kinder.bean.BabyModel> babyModel) {
		BabyModel = babyModel;
	}

	public int getBabynum() {
		return babynum;
	}

	public void setBabynum(int babynum) {
		this.babynum = babynum;
	}

	public int getParentnum() {
		return parentnum;
	}

	public void setParentnum(int parentnum) {
		this.parentnum = parentnum;
	}

	public int getIsreg() {
		return isreg;
	}

	public void setIsreg(int isreg) {
		this.isreg = isreg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<cn.kinder.bean.BabyModel> getHomeBabyModel() {
		return HomeBabyModel;
	}

	public void setHomeBabyModel(List<cn.kinder.bean.BabyModel> homeBabyModel) {
		HomeBabyModel = homeBabyModel;
	}
	
	
}
