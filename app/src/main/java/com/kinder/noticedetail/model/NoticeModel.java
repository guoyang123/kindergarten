package com.kinder.noticedetail.model;

import java.io.Serializable;

import cn.kinder.bean.UserModel;

public class NoticeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2639970783319452725L;

	
	private String addtime;
	private int adminid;
	private String articlefrom;
	private int classid;
	private String closetime;
	private int kinderid;
	private String noticecate;
	private String noticecontent;
	private int noticeid;
	private String noticetitle;
	private String noticetype;
	private int rank;
	private String regist;
	private int registcount;
	private int replycount;
	private String status;
	private String thumb;
	private UserModel userModel;
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getArticlefrom() {
		return articlefrom;
	}
	public void setArticlefrom(String articlefrom) {
		this.articlefrom = articlefrom;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClosetime() {
		return closetime;
	}
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}
	public int getKinderid() {
		return kinderid;
	}
	public void setKinderid(int kinderid) {
		this.kinderid = kinderid;
	}
	public String getNoticecate() {
		return noticecate;
	}
	public void setNoticecate(String noticecate) {
		this.noticecate = noticecate;
	}
	public String getNoticecontent() {
		return noticecontent;
	}
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}
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
	public String getNoticetype() {
		return noticetype;
	}
	public void setNoticetype(String noticetype) {
		this.noticetype = noticetype;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	public int getRegistcount() {
		return registcount;
	}
	public void setRegistcount(int registcount) {
		this.registcount = registcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	
}
