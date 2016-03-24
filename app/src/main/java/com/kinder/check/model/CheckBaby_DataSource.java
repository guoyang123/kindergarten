package com.kinder.check.model;

import java.io.Serializable;
import java.util.List;
import cn.kinder.bean.BabyCheckModel;
import cn.kinder.bean.Kinder_DataSource;

public class CheckBaby_DataSource extends Kinder_DataSource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825902032723616991L;

	
	private List<BabyCheckModel>  BabyCheckModel;


	public List<BabyCheckModel> getBabyCheckModel() {
		return BabyCheckModel;
	}


	public void setBabyCheckModel(List<BabyCheckModel> babyCheckModel) {
		BabyCheckModel = babyCheckModel;
	}
	
	
	
}
