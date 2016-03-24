package cn.kinder.bean;

import com.myt360.app.customviews.CircularImage;

public class UserPicModel {

	
	public static final int NORMAL=0;
	public static final int UPLOADING=1;
	private int status;
	private int position;//-1代表点击用户头像 0第一个baby。。。
	private CircularImage pic_CircularImage;
	
	
	
	
	public UserPicModel() {
		super();
	}
	public UserPicModel(int position, CircularImage pic_CircularImage) {
		super();
		this.position = position;
		this.pic_CircularImage = pic_CircularImage;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public CircularImage getPic_CircularImage() {
		return pic_CircularImage;
	}
	public void setPic_CircularImage(CircularImage pic_CircularImage) {
		this.pic_CircularImage = pic_CircularImage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
