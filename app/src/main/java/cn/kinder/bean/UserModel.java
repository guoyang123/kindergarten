package cn.kinder.bean;

import java.io.Serializable;


import net.tsz.afinal.annotation.sqlite.Table;

@Table(name="userModel")
public class UserModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1373430324207938156L;
//	@Colum
	private int id;
	private String userid;
	private String username;
	private String usertel;
	private String usertype;
	private String userpic;
	private String addtime;
	private String usersex;
	private String status;
	private int logcount;
	private int relation;
	private String classid;
	private String easemobid;//
	private String easemobpwd;
	public int getLogcount() {
		return logcount;
	}
	public void setLogcount(int logcount) {
		this.logcount = logcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getEasemobid() {
		return easemobid;
	}
	public void setEasemobid(String easemobid) {
		this.easemobid = easemobid;
	}
	public String getEasemobpwd() {
		return easemobpwd;
	}
	public void setEasemobpwd(String easemobpwd) {
		this.easemobpwd = easemobpwd;
	}
	
	
	
}
