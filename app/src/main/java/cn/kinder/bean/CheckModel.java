package cn.kinder.bean;

import java.io.Serializable;
/**教师考勤*/
public class CheckModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3303023258982101022L;

	private String checkid;
	private UserModel userModel	;//	用户模型，宝宝的家长
	private BabyModel babyModel	;// 	宝宝模型
	private String checktime	;//	 	签到时间 请假时为请假时间
	private String checkmold	;//	 	考勤类型0-请假 1-正常
	private String schoolid	;	 	//幼儿园编号
	private String schoolname	;//	幼儿园名称
	private String checktype	;//	请假类型0-病假1-事假2-休学
	private DiseaseModel DiseaseModel;
	private String checkhospital	;// 	就诊医院
	private String checkremark	;//	 	备注
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public BabyModel getBabyModel() {
		return babyModel;
	}
	public void setBabyModel(BabyModel babyModel) {
		this.babyModel = babyModel;
	}
	public String getChecktime() {
		return checktime;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	public String getCheckmold() {
		return checkmold;
	}
	public void setCheckmold(String checkmold) {
		this.checkmold = checkmold;
	}
	public String getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getChecktype() {
		return checktype;
	}
	public void setChecktype(String checktype) {
		this.checktype = checktype;
	}
	public DiseaseModel getDiseaseModel() {
		return DiseaseModel;
	}
	public void setDiseaseModel(DiseaseModel diseaseModel) {
		DiseaseModel = diseaseModel;
	}
	public String getCheckhospital() {
		return checkhospital;
	}
	public void setCheckhospital(String checkhospital) {
		this.checkhospital = checkhospital;
	}
	public String getCheckremark() {
		return checkremark;
	}
	public void setCheckremark(String checkremark) {
		this.checkremark = checkremark;
	}

	
	
	
	
}
