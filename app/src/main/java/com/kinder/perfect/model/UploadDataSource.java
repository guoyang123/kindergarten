package com.kinder.perfect.model;

import net.tsz.afinal.annotation.sqlite.Transient;
import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.UserPicModel;

public class UploadDataSource extends Kinder_DataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -575802287444616036L;

	private String fileurl;
	
    private transient UserPicModel userPicModel;
	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public UserPicModel getUserPicModel() {
		return userPicModel;
	}

	public void setUserPicModel(UserPicModel userPicModel) {
		this.userPicModel = userPicModel;
	}
	
	
}
