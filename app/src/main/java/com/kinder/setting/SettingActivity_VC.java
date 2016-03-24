package com.kinder.setting;

import android.os.Bundle;
import android.view.View;
import cn.com.iucd.iucdframe.eventmvc.EventMessage;

import com.kinder.about.AboutActivity_VC;
import com.kinder.forgetpsw.ForgetPswActivity_VC;
import com.kinder.setting.customviews.SettingMainViewXmlView;

public class SettingActivity_VC extends SettingActivity_BC {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mainView=new SettingMainViewXmlView(this,app.pro,app.screenW,app.screenH);
		setContentView(mainView);
		mainView.setListener(this);
		mainView.initMainViewData(setcachetv());
	}
	@Override
	public void onMessage(Object arg0) {
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

		int id=v.getId();
		if(id==mainView.titleBarView.leftBtn.getId())
		{
			this.finish();
		}else if(id==mainView.exit_Button.getId())
		{
			logic_clickExit();
		}else if(id==mainView.modifyPswView.getId())
		{
			skipActivity(ForgetPswActivity_VC.class,"type","updatepsw");
		}else if(id==mainView.cacheView.getId())//清除缓存
		{
			logic_clearCache();
		}else if(id==mainView.aboutView.getId())
		{
			skipActivity(AboutActivity_VC.class);
		}
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

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
