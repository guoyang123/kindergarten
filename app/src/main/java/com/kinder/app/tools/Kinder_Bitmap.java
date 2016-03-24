package com.kinder.app.tools;

import net.tsz.afinal.FinalBitmap;
import android.content.Context;

import com.myt360.app.consts.KinderConst;

/**
 * 
 * 加载图片
 * 
 * */
public class Kinder_Bitmap {

	/**
	 * 获取单例FinalBitmap
	 * */
	private  static volatile FinalBitmap finalBitmap;
	public static FinalBitmap getInstance(Context context){
		 
		if(finalBitmap==null)
		{
			synchronized (Kinder_Bitmap.class) {
				if(finalBitmap==null)
				{
					finalBitmap=FinalBitmap.create(context);
					String path=KinderConst.getSDPath();
					if(path!=null){
						finalBitmap=finalBitmap.configDiskCachePath(path);
					}
				}
			}
		}
		return finalBitmap;
	}
	
	

}
