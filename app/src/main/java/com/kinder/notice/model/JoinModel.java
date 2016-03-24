package com.kinder.notice.model;

import java.util.List;

import cn.kinder.bean.BabyModel;

public class JoinModel {

	
	private String isjoin;
	private String babyids;
	private List<BabyModel> babyModels;
	public JoinModel(String isjoin, String babyids) {
		super();
		this.isjoin = isjoin;
		this.babyids = babyids;
	}
	
	public JoinModel(String isjoin, String babyids, List<BabyModel> babyModels) {
		super();
		this.isjoin = isjoin;
		this.babyids = babyids;
		this.babyModels = babyModels;
	}

	public String getIsjoin() {
		return isjoin;
	}
	public void setIsjoin(String isjoin) {
		this.isjoin = isjoin;
	}
	public String getBabyids() {
		return babyids;
	}
	public void setBabyids(String babyids) {
		this.babyids = babyids;
	}
	public List<BabyModel> getBabyModels() {
		return babyModels;
	}
	public void setBabyModels(List<BabyModel> babyModels) {
		this.babyModels = babyModels;
	}
	
	
}
