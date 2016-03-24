package com.kinder.perfect.model;

import java.io.Serializable;
import java.util.List;


import cn.kinder.bean.BabyModel;
import cn.kinder.bean.ClassesModel;
import cn.kinder.bean.Kinder_DataSource;
import cn.kinder.bean.RelationModel;
import cn.kinder.bean.UserModel;


public class PerfectDataSource extends Kinder_DataSource implements
		Serializable 
		{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7765718115836680534L;
	
	private UserModel UserModel;
	private List<BabyModel> BabyModel;
	private List<RelationModel> RelationModel;
	private List<ClassesModel> ClassesModel;
	public UserModel getUserModel() {
		return UserModel;
	}
	public void setUserModel(UserModel userModel) {
		UserModel = userModel;
	}

	
	public List<BabyModel> getBabyModel() {
		return BabyModel;
	}
	public void setBabyModel(List<BabyModel> babyModel) {
		BabyModel = babyModel;
	}
	public List<ClassesModel> getClassesModel() {
		return ClassesModel;
	}
	public void setClassesModel(List<ClassesModel> classesModel) {
		ClassesModel = classesModel;
	}
	public List<RelationModel> getRelationModel() {
		return RelationModel;
	}
	public void setRelationModel(List<RelationModel> relationModel) {
		RelationModel = relationModel;
	}
	
	
	

}
