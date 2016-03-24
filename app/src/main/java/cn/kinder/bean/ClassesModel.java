package cn.kinder.bean;

import java.io.Serializable;

public class ClassesModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8004350081239670183L;
	private int classid	;//	班级id
	private String classname		;//	班级名称
	private int kinderid		;//幼儿园id
	private SchoolModel	schoolModel	;//	幼儿园模型
	private String classyear	;//	班级年份
	private String classpic		;//	班级照片
	private String classdescribe		;//班级描述
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getKinderid() {
		return kinderid;
	}
	public void setKinderid(int kinderid) {
		this.kinderid = kinderid;
	}
	public SchoolModel getSchoolModel() {
		return schoolModel;
	}
	public void setSchoolModel(SchoolModel schoolModel) {
		this.schoolModel = schoolModel;
	}
	public String getClassyear() {
		return classyear;
	}
	public void setClassyear(String classyear) {
		this.classyear = classyear;
	}
	public String getClasspic() {
		return classpic;
	}
	public void setClasspic(String classpic) {
		this.classpic = classpic;
	}
	public String getClassdescribe() {
		return classdescribe;
	}
	public void setClassdescribe(String classdescribe) {
		this.classdescribe = classdescribe;
	}
	
	
	

}
