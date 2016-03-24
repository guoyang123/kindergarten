package com.kinder.app.tools;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.content.Context;
import android.util.Log;
import cn.kinder.bean.LogininfoModel;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DBConst;
import cn.kinder.user.DbOperationModel;

/**
 * 
 * 网络请求类
 * 
 * */
public  class Kinder_Http extends FinalHttp{
	
	
	private static  Kinder_Http fh;
	
	private Context context;
	
	public static Kinder_Http  getBuzz_Http(Context context){
		if(fh==null){
			fh=new Kinder_Http(context);
			fh.configTimeout(10*1000);//10s
		}
		return fh;
	}
	public Kinder_Http(Context context) {
		super();
		this.context = context;
	}
	
	@Override
	public void post(String url, AjaxParams params,
			AjaxCallBack<? extends Object> callBack) {
		super.post(url, params, callBack);
		
		
//		/***
//		 * 
//		 * 持久登陆信息
//		 * 
//		 * */
//		LogininfoModel model=LogininfoModel.readFromFile(context);
//		UserModel userinfo=DbOperationModel.getUserInfo(context);
//		if(userinfo!=null){
//			params.put("logininfo_userid", userinfo.getUserid());//
//		}
//		if(model!=null){
//			params.put("logininfo_time", model.getTime());
//			params.put("logininfo_sign", LogininfoModel.getYueHuToken(model,userinfo!=null?userinfo.getUserid():null));//String.valueOf(System.currentTimeMillis()/1000)
//		}
//		
//		String device=  new DevicePlug_Util(context).getDeviceIMEI();
//		device=device.replaceAll(":", ",");
//		params.put("logininfo_device", device);
//	
		
		
		
		
	
	}
	

}
