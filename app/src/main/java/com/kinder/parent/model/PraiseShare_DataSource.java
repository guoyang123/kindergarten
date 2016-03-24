package com.kinder.parent.model;

import cn.kinder.bean.Kinder_DataSource;

public class PraiseShare_DataSource extends Kinder_DataSource {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -201429040899801633L;
	
	public static final String TOP="1";//顶
	public static final String STEP="2";//踩
	public static final String SHARE="3";//分享
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
}
