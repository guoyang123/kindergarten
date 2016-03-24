package com.kinder.app.tools;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


/*
 * 设备信息储存类
 */
public class DeviceInfo_Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6480956404662257935L;

	public final static String TAG = "DeviceInfo";
	
	public static DeviceInfo_Model mDeviceInfo;
	
	
	private String device; //用户设备唯一标识
	private String systems; //系统版本
	private String resolution; //分辨率
	private String edition; //版本
	private String devicename; //名称
	private String baiduuserid; //百度云id
	private String devicetoken; //ios devicetoken
	public  boolean isFirstSend;//是否已经发送过一次
	

	private String saveDate; //储存时间
	
	public static DeviceInfo_Model instance(Context context) {
		if (mDeviceInfo == null) {
			mDeviceInfo = readFromFile(context);
			
			if (mDeviceInfo == null) {
				mDeviceInfo = new DeviceInfo_Model();
			}
		}
		return mDeviceInfo;
	}
	
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSystems() {
		return systems;
	}

	public void setSystems(String systems) {
		this.systems = systems;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getBaiduuserid() {
		return baiduuserid;
	}

	public void setBaiduuserid(String baiduuserid) {
		this.baiduuserid = baiduuserid;
	}

	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	public String getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}
	
	
	public boolean isFirstSend() {
		return isFirstSend;
	}

	public void setFirstSend(boolean isFirstSend) {
		this.isFirstSend = isFirstSend;
	}

	public DeviceInfo_Model() {
		// TODO Auto-generated constructor stub
	}
	

	public DeviceInfo_Model(String device, String systems, String resolution,
			String edition, String devicename, String baiduuserid,
			String devicetoken, boolean isFirstSend, String saveDate) {
		super();
		this.device = device;
		this.systems = systems;
		this.resolution = resolution;
		this.edition = edition;
		this.devicename = devicename;
		this.baiduuserid = baiduuserid;
		this.devicetoken = devicetoken;
		this.isFirstSend = isFirstSend;
		this.saveDate = saveDate;
	}

	public boolean save(Context context){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			// 将Product对象转换成byte数组，并将其进行base64编码
			String productBase64 = new String(Base64.encodeBase64(baos.toByteArray()));
			SharedPreferences.Editor editor = context.getSharedPreferences(TAG, Activity.MODE_PRIVATE).edit();
			// 将编码后的字符串写到base64.xml文件中
			editor.putString(TAG, productBase64);
			editor.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static DeviceInfo_Model readFromFile(Context context) {
		
		DeviceInfo_Model config_Model = null;
		try {
			String productBase64 = context.getSharedPreferences(TAG, Activity.MODE_PRIVATE).getString(TAG, "");
			// 对Base64格式的字符串进行解码
			byte[] base64Bytes = Base64.decodeBase64(productBase64.getBytes());
			ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 从ObjectInputStream中读取Product对象
			config_Model = (DeviceInfo_Model) ois.readObject();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (config_Model == null) {
			config_Model = new DeviceInfo_Model();
		}
		return config_Model;
	}
}
