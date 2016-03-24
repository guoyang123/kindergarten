package com.kinder.check.model;

import java.io.Serializable;

import cn.kinder.bean.CheckModel;
import cn.kinder.bean.SaftyModel;

public class TeacherWrapModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4391272558998261547L;

	public static final int CHECKMODEL=0;
	public static final int SAFTYMODEL=1;
	private int type;//0:checkmodel 1：取saftymodel
	private CheckModel checkModel;
	private SaftyModel saftyModel;
	
	
	
	
	public TeacherWrapModel() {
		super();
	}
	public TeacherWrapModel(int type, CheckModel checkModel,
			SaftyModel saftyModel) {
		super();
		this.type = type;
		this.checkModel = checkModel;
		this.saftyModel = saftyModel;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public CheckModel getCheckModel() {
		return checkModel;
	}
	public void setCheckModel(CheckModel checkModel) {
		this.checkModel = checkModel;
	}
	public SaftyModel getSaftyModel() {
		return saftyModel;
	}
	public void setSaftyModel(SaftyModel saftyModel) {
		this.saftyModel = saftyModel;
	}
	
	
}
