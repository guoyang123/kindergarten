package com.myt360.kindergarten;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import cn.com.iucd.iucdframe.activity.IUCDFragmentActivity;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;
import cn.kinder.user.DbOperationModel;
import cn.kinder.util.MethodUtils;

import com.easemob.applib.controller.HXSDKHelper;
import com.kinder.app.loading.Buzz_LoadingDialog;
import com.kinder.app.tools.KinderNetWork;
import com.umeng.analytics.MobclickAgent;


/**
 * 程序基础Activity类
 * 
 * */
public abstract class Kind_BaseActivity extends IUCDFragmentActivity {

	protected float pro,screenW,screenH;
	protected EventMessage eventMessage;
	protected KinderApplication app;
	protected Buzz_LoadingDialog buzz_dialog;
	protected static List<FragmentActivity>  activitys=new ArrayList<FragmentActivity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		initPro();
		app.addActivity(this);
		
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			super.onCreate(savedInstanceState);
			
			
			
			buzz_dialog=Buzz_LoadingDialog.newInstance(this, app);
			activitys.add(this);
		
		
			
	}

	

	    /**杀死进程并重启应用*/
	  protected void restartApp()
	  {
//		  android.os.Process.killProcess(android.os.Process.myPid());
//		  ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//		  am.restartPackage("com.myt360.kindergarten");
//		  Intent k = this.getPackageManager()
//				  .getLaunchIntentForPackage("com.myt360.kindergarten");
//				  k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				  this.startActivity(k);
//		  System.exit(0);
//		  Intent it=new Intent(this,MainActivity.class);
//		  this.startActivity(it);
		  
//		  ActivityManager am = (ActivityManager) this.getSystemService(this.ACTIVITY_SERVICE);
//		  am.restartPackage("com.myt360.kindergarten");
	  }
		
	    
	  
	
	  
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("kill_code", 123);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		destroyEventMessage();
		buzz_dialog=null;
		app.removeActivity(this);
	}
	/**
	 * 
	 * 启动loading动画
	 * 
	 * */
	protected void startLoading(){

		FragmentManager fm=getSupportFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		ft.addToBackStack("bkw_dialog");
		ft.commit();
		buzz_dialog.setCancelable(false);
		if(!isFinishing())
		{
			buzz_dialog.show(getSupportFragmentManager(), "bkw_dialog");
		}
		
		
	}
	
	
	/**
	 * 
	 * 结束动画
	 * 
	 * */
	protected void stopLoading(){
		
		
			buzz_dialog.dismiss();
		
		
		
	}
	
	/**
	 * 初始化适配参数
	 * */
	private void initPro()
	{
		app=(KinderApplication)getApplication();
		pro=app.getPro();
		screenW=app.getScreenW();
		screenH=app.getScreenH();
	}
	
	
	/**获取消息类*/
	public EventMessage getEventMessage() {
		if(eventMessage==null)
		{
			eventMessage=new EventMessage();
		}
		return eventMessage;
	}
	/**注销消息*/
	public void destroyEventMessage()
	{
		if(eventMessage!=null)
		{
			eventMessage.unregister(this);
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// onresume时，取消notification显示
        HXSDKHelper.getInstance().getNotifier().reset();
        
        // umeng
        MobclickAgent.onResume(this);
	}
	 @Override
	    protected void onStart() {
	        super.onStart();
	        // umeng
	        MobclickAgent.onPause(this);
	    }

	 
	 @Override
	public void onMessageMainThread(Object arg0) {
		// TODO Auto-generated method stub
		 MethodUtils.logic_ErrorCode(this,arg0);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPause(this);
	}

	 /**
     * 返回
     * 
     * @param view
     */
    public void back(View view) {
        finish();
    }

	
	/**启动Activity*/
	protected void skipActivity(Class cls)
	{
		Intent it=new Intent(this,cls);
		this.startActivity(it);
	}
	/**启动Activity*/
	protected void skipActivity(Class cls,String key,String value)
	{
		Intent it=new Intent(this,cls);
		it.putExtra(key, value);
		this.startActivity(it);
	}
	/**启动Activity*/
	protected void skipActivity(Class cls,String key,Serializable value)
	{
		Intent it=new Intent(this,cls);
		it.putExtra(key, value);
		this.startActivity(it);
	}
	/**启动Activity*/
	protected void skip2Activity(Class cls,String key,Serializable value)
	{
		Intent it=new Intent(this,cls);
		Bundle bundle=new Bundle();
		bundle.putSerializable(key, value);
		it.putExtra("bundle",bundle);
		startActivity(it);
	}
	/**启动Activity*/
	protected void skipActivity(Class cls,String key,String value,String key2,String value2,String key3,String value3)
	{
		Intent it=new Intent(this,cls);
		it.putExtra(key, value);
		it.putExtra(key2, value2);
		it.putExtra(key3, value3);
		this.startActivity(it);
	}
	protected void skipActivity(Class cls,String key,String value,String key2,String value2)
	{
		Intent it=new Intent(this,cls);
		it.putExtra(key, value);
		it.putExtra(key2, value2);
		this.startActivity(it);
	}
	/**启动Activity*/
	protected void skipActivity(Class cls,HashMap<String,String> map)
	{
		Intent it=new Intent(this,cls);
		Bundle bundle=new Bundle();
		if(map!=null)
		{
			for(Map.Entry<String, String> entry:map.entrySet()){    
				bundle.putString(entry.getKey(), entry.getValue());
			}   
			it.putExtra("map", bundle);
		}
		this.startActivity(it);
	}
	
	/**启动OrderConfirmActivity*/
	protected void skipActivity(Class cls,HashMap<String,String> map,Serializable ser)
	{
		Intent it=new Intent(this,cls);
		Bundle bundle=new Bundle();
		bundle.putSerializable("orderconfirm_datasource", ser);
		if(map!=null)
		{
			for(Map.Entry<String, String> entry:map.entrySet()){    
				bundle.putString(entry.getKey(), entry.getValue());
			}   
			it.putExtra("map", bundle);
		}
		
		this.startActivity(it);
	}

	
	/**获取用户信息*/
	public UserModel getUserInfo()
	{
		return DbOperationModel.getUserInfo(this);
	}
	
	
	/**获取活动详细接口
	 * 
	 * @param type 0:非活动 1：活动
	 * */
	protected void interface_getNoticeDetail_byNetWork(String noticeid,String type)
	{
		KinderNetWork.interface_getNoticeDetail_byNetWork(this, getEventMessage(),noticeid,type);
	}
	
}
