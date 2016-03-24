package com.kinder.startup;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.kinder.bean.UserModel;

import com.easemob.chatuidemo.DemoHXSDKHelper;
import com.kinder.login.LoginActivity_VC;
import com.kinder.menu.MenuActivity_VC;
import com.kinder.startup.customviews.StartUpMainViewXmlView;

public class StartUpActivity_VC extends StartUpActivity_BC {

	public Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			UserModel usermodel=getUserInfo();
			if(usermodel==null||usermodel.getLogcount()==1)
			{
				//跳转到主页面
				skipActivity(LoginActivity_VC.class);
				finish();
			}else
			{
				//hxLogin(usermodel);
				if (DemoHXSDKHelper.getInstance().isLogined())
				{
					autoLogin = true;
					startActivity(new Intent(StartUpActivity_VC.this, MenuActivity_VC.class));
					StartUpActivity_VC.this.finish();
					return;
				}else
				{
					skipActivity(LoginActivity_VC.class);
					StartUpActivity_VC.this.finish();
				}
				
			}
			
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new StartUpMainViewXmlView(this,app.pro,app.screenW,app.screenH);
	    setContentView(mainView);
        new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mHandler.obtainMessage().sendToTarget();
			}
		}, 2000);
	}
	@Override
	public void onMessage(Object arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageBackgroundThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageMainThread(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventMessage initLocalEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventMessage initPlugEventMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
