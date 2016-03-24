package com.kinder.menu.model;

public class SlideModel 
{

	private String icon;
	private String text;
	private boolean isshow;//是否显示右侧的开关
	private boolean isline;//true:已开 
	
	
	
	
	
	public SlideModel() {
		super();
	}
	public SlideModel(String icon, String text, boolean isshow, boolean isline) {
		super();
		this.icon = icon;
		this.text = text;
		this.isshow = isshow;
		this.isline = isline;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isIsshow() {
		return isshow;
	}
	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}
	public boolean isIsline() {
		return isline;
	}
	public void setIsline(boolean isline) {
		this.isline = isline;
	}
	
	
}
