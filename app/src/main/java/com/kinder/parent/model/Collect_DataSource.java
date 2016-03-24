package com.kinder.parent.model;

import cn.kinder.bean.Kinder_DataSource;

public class Collect_DataSource extends Kinder_DataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2904733631411354842L;

	/**1:收藏 2：取消收藏*/
	private String collect;

	public String getCollect() {
		return collect;
	}

	public void setCollect(String collect) {
		this.collect = collect;
	}
	
	
}
