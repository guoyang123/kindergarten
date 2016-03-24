package com.kinder.check.model;

import java.io.Serializable;
import java.util.List;
import cn.kinder.bean.BabyCheckTimeModel;
import cn.kinder.bean.Kinder_DataSource;

public class CheckBabyMonth_DataSource extends Kinder_DataSource implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5175170984029004383L;

	private List<BabyCheckTimeModel> BabyCheckTimeModel ;

	private String time;//请求接口传递的时间。保留字段
	public List<BabyCheckTimeModel> getBabyCheckTimeModel() {
		return BabyCheckTimeModel;
	}

	public void setBabyCheckTimeModel(List<BabyCheckTimeModel> babyCheckTimeModel) {
		this.BabyCheckTimeModel = babyCheckTimeModel;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
