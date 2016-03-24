package com.kinder.chat.model;

import java.io.Serializable;
import java.util.List;

import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.UserModel;

public class ContactUser_DataSource extends Kinder_DataSource implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -174880330478771936L;

	
	private List<ContactModel> UberModelList;


	public List<ContactModel> getUberModelList() {
		return UberModelList;
	}


	public void setUberModelList(List<ContactModel> uberModelList) {
		UberModelList = uberModelList;
	}


	
	
	
}
