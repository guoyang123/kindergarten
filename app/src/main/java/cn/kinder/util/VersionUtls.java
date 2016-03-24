package cn.kinder.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class VersionUtls {

	
	/**
	 * 
	 * 获取当前应用的版本号：
	 * 
	 * 
	 */

	   public static String getVersionName(Context context)
	   {
	           // 获取packagemanager的实例
	           PackageManager packageManager = context.getPackageManager();
	           // getPackageName()是你当前类的包名，0代表是获取版本信息
	           PackageInfo packInfo;
			try {
				packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
				String version = packInfo.versionName;
		           return version;
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "0.0";
			}
	           
	   }
}
