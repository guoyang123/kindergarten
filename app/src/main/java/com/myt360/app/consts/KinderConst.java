package com.myt360.app.consts;

import java.io.File;

import android.os.Environment;

public class KinderConst {

	
	//public static final String VERSION="3.6";
	public static final String TITLE_BACKGROUND="#1da3fc";
	/**
	 * 
	 * 缓存路径
	 * 
	 * */
	public static String getSDPath(){ 
	       String sdDir = null; 
	       boolean sdCardExist = Environment.getExternalStorageState()   
	                           .equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在 
	       if(sdCardExist) {                               
	         sdDir = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"kinder"+File.separator+"caching";//获取跟目录 
	         return sdDir;
	      }   
	       return null; 

	}
	
	/**
	 * 
	 * apk下载路径及缓存清理路径
	 * 
	 * */
	public static String getApkPath(){
	    String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+ "kinder";
		return path;
	}
	
}
