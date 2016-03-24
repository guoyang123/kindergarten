package com.kinder.login.model;

import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.LogininfoModel;
import cn.kinder.bean.UserModel;


public class Login_DataSource extends Kinder_DataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -203401490304222922L;

	
	private UserModel UserModel;
	private LogininfoModel LogininfoModel;
	public UserModel getUserModel() {
		return UserModel;
	}
	public void setUserModel(UserModel userModel) {
		this.UserModel = userModel;
	}
	public LogininfoModel getLogininfoModel() {
		return LogininfoModel;
	}
	public void setLogininfoModel(LogininfoModel logininfoModel) {
		LogininfoModel = logininfoModel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
