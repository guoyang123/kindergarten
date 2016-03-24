package com.kinder.noticedetail.model;

import java.io.Serializable;

import cn.kinder.bean.Kinder_DataSource;

public class NoticeDetail_Non_DataSource extends Kinder_DataSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8590077465557725589L;

	private NoticeModel NoticeModel;

	public NoticeModel getNoticeModel() {
		return NoticeModel;
	}

	public void setNoticeModel(NoticeModel noticeModel) {
		NoticeModel = noticeModel;
	}
	
	
}
