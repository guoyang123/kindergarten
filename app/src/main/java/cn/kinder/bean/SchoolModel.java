package cn.kinder.bean;

import java.io.Serializable;

public class SchoolModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7956942546033356034L;
	
	private int schoolid	;
	private String schoolname;//	学校名称	
	private String schooladdres;//	学校地址	
	private String schoolmark;//	是否启用群功能0-开群 1-关群
	private String schoolpic	;//	学校照片	
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getSchooladdres() {
		return schooladdres;
	}
	public void setSchooladdres(String schooladdres) {
		this.schooladdres = schooladdres;
	}
	public String getSchoolmark() {
		return schoolmark;
	}
	public void setSchoolmark(String schoolmark) {
		this.schoolmark = schoolmark;
	}
	public String getSchoolpic() {
		return schoolpic;
	}
	public void setSchoolpic(String schoolpic) {
		this.schoolpic = schoolpic;
	}

	
}
