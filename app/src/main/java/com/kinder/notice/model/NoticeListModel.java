package com.kinder.notice.model;

import java.io.Serializable;

import cn.kinder.bean.UserModel;

public class NoticeListModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2735102588969866212L;
	private int noticeid	;//通知id
	private String noticetitle	;//通知标题
	private String noticecate	;//通知分类 食谱-1 教学-2 活动-3 通知-4
	private String thumb	;//图片
	private int adminid	;//	添加的管理员id
	private UserModel userModel	;//用户模型
	private String addtime	;//添加时间
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getNoticecate() {
		return noticecate;
	}
	public void setNoticecate(String noticecate) {
		this.noticecate = noticecate;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	

}
