package com.kinder.notice.model;

import java.util.List;

import cn.kinder.bean.Kinder_DataSource;

public class Notice_DataSource extends Kinder_DataSource {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8210669653608764475L;
	private List<NoticeListModel> NoticeListModel;

	public List<NoticeListModel> getNoticeListModel() {
		return NoticeListModel;
	}

	public void setNoticeListModel(List<NoticeListModel> noticeListModel) {
		NoticeListModel = noticeListModel;
	}
	
	
}
