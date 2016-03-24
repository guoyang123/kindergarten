package cn.kinder.bean;

import java.io.Serializable;

import net.tsz.afinal.annotation.sqlite.Transient;

public class BabyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4144200007123642433L;
	
	private int babyid;
	private String babyname	;//	宝宝姓名
	private String studientid	;//	学号
	private String babypic	;//	宝宝照片
	private int kinderid	;//	幼儿园id
	private int classid	;//	班级id
	private  ClassesModel classesModel	;//	班级模型
	private String babyyear;//入学年份
	private String babysex	;//	0-女1-男
	private String babybirth	;//	出生日期
	private int babyage	;//	宝宝年龄
	
	//宝宝参加活动，是否被选择
	private boolean isSelected;

	public int getBabyid() {
		return babyid;
	}
	public void setBabyid(int babyid) {
		this.babyid = babyid;
	}
	public String getBabyname() {
		return babyname;
	}
	public void setBabyname(String babyname) {
		this.babyname = babyname;
	}
	
	
	public String getStudientid() {
		return studientid;
	}
	public void setStudientid(String studientid) {
		this.studientid = studientid;
	}
	public String getBabyyear() {
		return babyyear;
	}
	public void setBabyyear(String babyyear) {
		this.babyyear = babyyear;
	}
	public String getBabysex() {
		return babysex;
	}
	public void setBabysex(String babysex) {
		this.babysex = babysex;
	}
	public String getBabypic() {
		return babypic;
	}
	public void setBabypic(String babypic) {
		this.babypic = babypic;
	}
	public int getKinderid() {
		return kinderid;
	}
	public void setKinderid(int kinderid) {
		this.kinderid = kinderid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}


	
	public ClassesModel getClassesModel() {
		return classesModel;
	}
	public void setClassesModel(ClassesModel classesModel) {
		this.classesModel = classesModel;
	}
	public String getBabybirth() {
		return babybirth;
	}
	public void setBabybirth(String babybirth) {
		this.babybirth = babybirth;
	}
	public int getBabyage() {
		return babyage;
	}
	public void setBabyage(int babyage) {
		this.babyage = babyage;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	

}
