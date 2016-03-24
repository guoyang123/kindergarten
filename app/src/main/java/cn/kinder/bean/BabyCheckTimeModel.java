package cn.kinder.bean;

import java.io.Serializable;

public class BabyCheckTimeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8343377267189050685L;

	private String checkstart;
	private String checkend;
	public String getCheckstart() {
		return checkstart;
	}
	public void setCheckstart(String checkstart) {
		this.checkstart = checkstart;
	}
	public String getCheckend() {
		return checkend;
	}
	public void setCheckend(String checkend) {
		this.checkend = checkend;
	}
	
}
