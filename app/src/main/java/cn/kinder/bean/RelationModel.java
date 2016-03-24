package cn.kinder.bean;

import java.io.Serializable;

public class RelationModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3989458064493771256L;
	private String addtime;
	private int adduser;
	private int relationid;
	private String relationname;
	private String relationstat;
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getAdduser() {
		return adduser;
	}
	public void setAdduser(int adduser) {
		this.adduser = adduser;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public String getRelationname() {
		return relationname;
	}
	public void setRelationname(String relationname) {
		this.relationname = relationname;
	}
	public String getRelationstat() {
		return relationstat;
	}
	public void setRelationstat(String relationstat) {
		this.relationstat = relationstat;
	}
	
	
}
