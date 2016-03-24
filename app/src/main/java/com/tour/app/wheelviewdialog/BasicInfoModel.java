package com.tour.app.wheelviewdialog;

public class BasicInfoModel {

	private String typecode;
	private String typename;
	
	
	public BasicInfoModel() {
		super();
	}
	public BasicInfoModel(String typecode, String typename) {
		super();
		this.typecode = typecode;
		this.typename = typename;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	
	
	
	
}
