package com.kinder.app.tools;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class DevicePlug_Util {
	TelephonyManager tm;
	Context context;
	public DevicePlug_Util(Context context) {
		this.context = context;
		tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);  
	}

	/**
	 * 获取imei
	 * @return
	 */
	public String getDeviceIMEI() {
		// TODO Auto-generated method stub
		String imei = "";
		try{
			if (tm != null) {
				imei = tm.getDeviceId();
				if(imei==null||imei.equals(""))
				{
					imei = getLocalMacAddress();
				}
			}else {
				imei = getLocalMacAddress();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return imei;
		//return "a0,86,c6,48,f3,f5";
	}
	
	/**
	 * 获取mac地址
	 * @return
	 */
	public String getLocalMacAddress() {
		WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		return info.getMacAddress();
	}
	
	/**
	 * 获取设备名称
	 * @return
	 */
	public String getDeviceName() {
		String deviceName = android.os.Build.MODEL;
		if (deviceName == null || deviceName.length() <= 0) {
			deviceName = "Android Device";
		}
		return deviceName;
	}
	
	/**
	 * 获取系统版本号
	 * @return
	 */
	public String getSystemNumber() {
		String systemNum = android.os.Build.VERSION.SDK;
		if (systemNum == null || systemNum.length() <= 0) {
			systemNum = "0";
		}
		return systemNum;
	}
	
	/**
	 * 获取系统版本
	 * @return
	 */
	public String getSystemVersion(){
		String tmp = android.os.Build.VERSION.RELEASE;
		if (tmp == null || tmp.length() <= 0) {
			tmp = "0";
		}
		return tmp;
	}
	
}
