package com.kinder.chat.model;

import java.io.Serializable;

import cn.kinder.bean.BabyModel;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;

public class ContactModel implements Serializable {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -8360348048860840867L;
	private BabyModel babyModel;
	private RelationModel relationModel;
	private UserModel userModel;
	public BabyModel getBabyModel() {
		return babyModel;
	}
	public void setBabyModel(BabyModel babyModel) {
		this.babyModel = babyModel;
	}
	public RelationModel getRelationModel() {
		return relationModel;
	}
	public void setRelationModel(RelationModel relationModel) {
		this.relationModel = relationModel;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
}
