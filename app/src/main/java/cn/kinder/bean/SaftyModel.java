package cn.kinder.bean;

import java.io.Serializable;

public class SaftyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2700925769933579340L;

	private String saftyid	;//	安全码ID
	private String saftycode	;//	安全码
	private UserModel userModel	;//	 	用户模型，宝宝的家长
	private String teacherid	;//		 	
	private BabyModel	babyModel ;//	 	宝宝模型
	private String status	;//	 	状态0-成功1-失败2-过期
	private String addtime	;//		 	添加时间
	private String usertel	;//	 	用户手机号
	private String saftydate	;//		 	发送日期
	public String getSaftyid() {
		return saftyid;
	}
	public void setSaftyid(String saftyid) {
		this.saftyid = saftyid;
	}
	public String getSaftycode() {
		return saftycode;
	}
	public void setSaftycode(String saftycode) {
		this.saftycode = saftycode;
	}
	
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getSaftydate() {
		return saftydate;
	}
	public void setSaftydate(String saftydate) {
		this.saftydate = saftydate;
	}

	
	
}
